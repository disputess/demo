package com.example.web.controller;

import com.alibaba.excel.util.DateUtils;
import com.example.domain.entity.BikeEntity;
import com.example.domain.entity.BikeOpStatEntity;
import com.example.domain.entity.ShareDatasourcesTableEntity;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.service.ShareOpStatService;
import com.example.service.TestService;
import com.example.service.utils.easyexcel.EasyExcelUtils;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
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
    private static final int THREAD_NUM = 10;//执行的线程数

    @RequestMapping(value = "/share/table")
    public void shareTable() {
        shareOpStatService.insertShareOpStat();
        logger.info("分表成功");
    }

    @RequestMapping(value = "/create/table")
    public void createTable() {
        testService.createTable();
        logger.info("建表成功");
    }

    @RequestMapping(value = "/insert/List")
    public void insertList() {
        shareOpStatService.insertList();
        logger.info("分库分表插入成功");
    }

    @RequestMapping(value = "/select/list")
    public String selectList() {
        List<ShareDatasourcesTableEntity> list = shareOpStatService.selectList();
        for (ShareDatasourcesTableEntity shareDatasourcesTableEntity : list) {
            System.out.println(shareDatasourcesTableEntity.toString());
        }
        logger.info("分库分表查询成功");
        return  list.toString();


    }

    @RequestMapping(value = "/export/bike/log")
    public void getBikeOpListOne(HttpServletResponse response) {
        String fileName = "车辆最后日志导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BikeOpStatEntity> log = new ArrayList<BikeOpStatEntity>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("bike1.txt"));
        } catch (IOException e) {
            logger.error("车辆.txt 失败", e);
            e.printStackTrace();
        }
        for (String plateNo : list) {
            Long bikeId = shareOpStatService.selectBikeIdByPlateNo(plateNo);
            if (bikeId != null && bikeId > 0) {
                BikeOpStatEntity bikeLog = shareOpStatService.getBikeOpListOne(bikeId);
                if (bikeLog != null) {
                    log.add(bikeLog);
                }
            }
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, BikeOpStatEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/import/excel/log")
    public void importexcel(HttpServletResponse response) {
        //Resource resource = new ClassPathResource("bike.xlsx");
        try {
            //InputStream inputStream1 = resource.getInputStream();
            File file= ResourceUtils.getFile("classpath:bike.xlsx");
              //BufferedReader inputStream = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            // String filePath = Thread.currentThread().getContextClassLoader().getResource("battery.xlsx").getPath();
            //  File file =new File(ImportBattery.class.getClassLoader().getResource("../../resources/battery.xlsx").getPath());
             FileInputStream inputStream = new FileInputStream(file);
            //InputStream inputStream = file.get
           // InputStream inputStream = file.getInputStream();
            Workbook excel = WorkbookFactory.create(inputStream);
            //获取excel表中下标为1的第一张表的内容
            XSSFSheet sheet = (XSSFSheet) excel.getSheetAt(0);
            //获取最大行下标
            int maxRow = sheet.getLastRowNum();
            //循环获取行级元素,i小于等于最大的下标，等于是获取最后一行
            for (int i = 1; i <= maxRow; i++) {
                XSSFRow row = sheet.getRow(i);
                // 北京小蜜新能源汽车服务有限公司天津分公司
                System.out.println(row.getCell(0).getStringCellValue());
                /*
                if (row.getCell(3) != null) {
                    batteryParam.setCompanyId((long) row.getCell(1).getNumericCellValue());
                }
                */
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            //io异常
        } catch (IOException e) {
            e.printStackTrace();
            //poi读取execl格式异常
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
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
