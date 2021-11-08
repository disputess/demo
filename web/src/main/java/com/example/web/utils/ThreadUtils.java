package com.example.web.utils;

import com.example.domain.entity.BaseDto;
import com.example.domain.entity.BatteryEntity;
import com.example.service.TestService;
import com.example.service.ThreadUtilsService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

public class ThreadUtils<U extends ThreadUtilsService> {
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);
    @Autowired
    private TestService testService;
    public ExecutorService executor = Executors.newFixedThreadPool(20);//定义线程
    private U detailService;

    public ThreadUtils(U service) {
        this.detailService = service;
    }

    /**
     * 任务分发
     *
     * @param taskList =Collections.synchronizedList(new ArrayList<>()) 为了保证list顺序处理需要这样定义
     */
    public List<T> runTask(List<T> taskList, ExecutorService executor) {
        Long start = System.currentTimeMillis();
        List<T> list = Collections.synchronizedList(new ArrayList<>());
        int totalSize = taskList.size();
        int ts = 20;//线程数目
        if (ts > totalSize) {
            ts = totalSize;
        }
        final CountDownLatch doneSignal = new CountDownLatch(ts);
        int m = totalSize / ts;
        for (int k = 0; k < ts; k++) {
            int startIndex = k * m;
            int endIndex = (k + 1) * m;
            if (k == ts - 1) {
                endIndex = totalSize;
            }
            List<T> subList = taskList.subList(startIndex, endIndex);
            logger.info("线程需要处理的任务数量" + subList.size());
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Long startTime = System.currentTimeMillis();
                    // 执行业务
                    for (T bo : subList) {
                        // 数据计算与封装或者查询数据库
                        list.add(bo);
                    }
                    //任务执行完毕递减锁存器的计数
                    doneSignal.countDown();
                    long endTime = System.currentTimeMillis();
                    logger.info("线程名字:" + Thread.currentThread().getName() + " 线程id:" + Thread.currentThread().getId() + "本次业务代码逻辑执行完成，进行countdown--;耗时:" + (endTime - startTime));
                }
            });
        }
        try {
            doneSignal.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        logger.info("20个线程执行完毕总耗时" + (end - start));
        return list;
    }



    /**
     * 使用默认参数
     *
     * @param dto
     * @param tClass
     * @return
     * @throws Throwable
     */
    public <T extends BaseDto> List getData(T dto, Class<T> tClass) throws Throwable {
        int threadSize = 5;
        int countLimit = 10000;
        int pageSize = 4000;
        return getData(dto, tClass, threadSize, countLimit, pageSize);
    }

    /**
     * 多线程获取大数据信息
     *
     * @param dto        参数对象
     * @param tClass     参数class 用于实例化
     * @param threadSize 定义线程数
     * @param countLimit 限制超过多少数量进行多线程处理
     * @param pageSize   每个线程条数限制
     * @param <T>
     * @return
     * @throws Throwable
     */
    public <T extends BaseDto> List getData(T dto, Class<T> tClass, int threadSize, int countLimit, int pageSize) throws Throwable {
        //线程池定义
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("Muti-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(threadSize, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        dto.setPageNum(null);
        dto.setPageSize(null);
        List attendanceRes = new ArrayList<>();
        Long count = detailService.getListCount(dto);
        logger.info("总记录数:" + count);
        if (count <= countLimit) {
            dto.setPageNum(0);
            dto.setPageSize(countLimit);
            attendanceRes = detailService.getThreadList(dto, 0, countLimit);
            return attendanceRes;
        }

        int pageStart = 0;
        List<ExecThread<T>> tasks = new ArrayList<>();
        for (int i = 0; i < threadSize; i++) {
            //每个线程要完成的总数
            int totalCount = (int) Math.floor((double) count / threadSize);
            if (i > 0) {
                pageStart += totalCount;
            }
            if (i == threadSize - 1) {
                totalCount = (int) (totalCount + (count % threadSize));
            }

            T operatorAttendance = tClass.newInstance();
            BeanUtils.copyProperties(dto, operatorAttendance);
            ExecThread task = new ExecThread(totalCount, pageSize, pageStart, operatorAttendance);
            tasks.add(task);
        }
        try {
            List<Future<List>> list = executor.invokeAll(tasks);
            for (Future<List> result : list) {
                List listone = null;
                try {
                    listone = result.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                attendanceRes.addAll(listone);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        executor.shutdown();

        logger.info("导出总记录条数{}" + attendanceRes.size());
        return attendanceRes;

    }

    class ExecThread<T extends BaseDto> implements Callable<List> {
        public ExecThread() {
        }

        private long totalCount;
        private int pageSize;
        private int pageStart;
        private T dto;

        public ExecThread(long totalCount, int pageSize, Integer pageStart, T dto) {
            this.totalCount = totalCount;
            this.dto = dto;
            this.pageSize = pageSize;
            this.pageStart = pageStart;
        }

        @Override
        public List call() throws Exception {
            logger.info("线程名字==========" + Thread.currentThread().getName());
            List list = new ArrayList<>();
            int totalPage = (int) Math.floor((double) totalCount / pageSize);
            if (totalPage == 0) {
                totalPage += 1;
                pageSize = (int) totalCount;
            }
            logger.info("线程名称{}，总页数{}", Thread.currentThread().getName(), totalPage);
            int start = pageStart;
            int size = pageSize;
            for (int i = 0; i < totalPage; i++) {
                if (i != 0) {
                    start = start + pageSize;
                }
                dto.setPageNum(start);
                // 如果是最后一组，size要把余数加上
                if (i == totalPage - 1) {
                    size = (int) (pageSize + (totalCount % pageSize));
                }
                dto.setPageSize(size);
                long startTime = System.currentTimeMillis();
                Thread.sleep(50);
                List attendanceList = detailService.getThreadList(dto, start, size);
                list.addAll(attendanceList);
                logger.info("集合数据：" + attendanceList.size());
                logger.info("################查询耗时：" + (System.currentTimeMillis() - startTime) + "当前线程：" + Thread
                        .currentThread().getName() + "==start==" + start + "=====size==" + size);
            }
            return list;
        }
    }
}
