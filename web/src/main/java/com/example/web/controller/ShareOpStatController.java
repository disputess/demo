package com.example.web.controller;

import com.alibaba.excel.util.DateUtils;
import com.example.domain.entity.BikeEntity;
import com.example.domain.entity.ShareDatasourcesTableEntity;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.service.ShareOpStatService;
import com.example.service.TestService;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("/test")
public class ShareOpStatController {
    private static final Logger logger = LoggerFactory.getLogger(ShareOpStatController.class);

    @Autowired
    private ShareOpStatService shareOpStatService;

    @Autowired
    private TestService testService;
    public static int count;
    public ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);//定义线程
    private  static final int  THREAD_NUM=10;//执行的线程数

    @RequestMapping(value = "/share/table")
    public void shareTable(){
        ShareOpStatEntity shareOpStatEntity = new ShareOpStatEntity();
        shareOpStatEntity.setShareId(55L);
        shareOpStatEntity.setName("徐辣鸡");
        shareOpStatService.insertShareOpStat(shareOpStatEntity);

        logger.info("分表成功");
    }
    @RequestMapping(value = "/create/table")
    public void createTable(){
        testService .createTable();
        logger.info("建表成功");
    }
    @RequestMapping(value = "/insert/List")
    public void insertList(){
        shareOpStatService.insertList();
        logger.info("分库分表插入成功");
    }
    @RequestMapping(value = "/select/list")
    public void selectList(){
       List<ShareDatasourcesTableEntity>  list  = shareOpStatService.selectList();
       for(ShareDatasourcesTableEntity shareDatasourcesTableEntity:list){
           System.out.println(shareDatasourcesTableEntity.toString());
       }
        logger.info("分库分表查询成功");
    }
   /* @RequestMapping(value = "/tt")
    public void tt(){
        List<BikeEntity>  list  = Collections.synchronizedList(new ArrayList<>());
        for(int i =1 ;i<100000;i++){
            BikeEntity bikeEntity = new BikeEntity();
            bikeEntity.setPlateNo(""+i);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                bikeEntity.setCreateTime(sdf.parse("2020-09-07 12:05:28"));
                bikeEntity.setUpdateTime(sdf.format(sdf.parse("2020-09-07 12:05:28")));

            } catch (Exception e) {
                logger.error("上次换电时间转换出错", e);
            }
            list.add(bikeEntity);
        }

        List<BikeEntity> resultList =  runTask(list,executor);
        for(BikeEntity bikeEntity: resultList){
            System.out.println(bikeEntity.getPlateNo()+"-----------"+bikeEntity.getAddress());
        }
    }*/

    /**
     * 任务分发
     *
     * @param taskList
     *//*
    public List<BikeEntity> runTask(List<BikeEntity> taskList, ExecutorService executor) {
        List<BikeEntity> list= Collections.synchronizedList(new ArrayList<>());
        int totalSize = taskList.size();
        int ts = 10;//线程数目
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
            List<BikeEntity> subList = taskList.subList(startIndex, endIndex);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Long startTime = System.currentTimeMillis();
                    for (BikeEntity bikeEntity : subList) {
                        // 执行业务
                        bikeEntity.setAddress(bikeEntity.getPlateNo());
                        list.add(bikeEntity);
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
        return list;
    }*/
}
