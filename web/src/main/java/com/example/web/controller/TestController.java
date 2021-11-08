package com.example.web.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.example.common.utils.AMapUtil;
import com.example.common.utils.GpsUtils;
import com.example.domain.entity.*;
import com.example.service.ShareOpStatService;
import com.example.service.TestService;
import com.example.service.utils.easyexcel.EasyExcelUtils;
import com.example.web.annotation.SysOperatorLog;
import com.example.web.enums.BikeStateEnum;
import com.example.web.enums.OperatorTaskCancelTypeEnum;
import com.example.web.enums.TaskSubTypeEnum;
import com.example.web.enums.TaskTypeEnum;
import com.example.web.utils.DateUtils;
import com.example.web.utils.ThreadUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 宋爸爸专用类，闲杂人等不要乱动
@Deprecated
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
    @Autowired
    private ShareOpStatService shareOpStatService;

    public ExecutorService executor = Executors.newFixedThreadPool(20);//定义线程


    @SysOperatorLog
    @RequestMapping(value = "/getAll")
    public String getAll(Long testId, String testName) {
        List<TestEntity> list = new ArrayList<>();
        return list.get(0).toString();
    }

    @RequestMapping(value = "/change/datasource")
    public String changeDatasource() {
        List<UsersEntity> list = testService.changeDatasource();
        return list.toString();
    }

    /**
     * 根据电池编号进行电池最后日志导出
     *
     * @param response
     */
    @RequestMapping("/operator/info/export")
    public void operatorInfoExport(HttpServletResponse response) {
        String fileName = "电池最后一条日志导出" + System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BatteryLogEntity> log = new ArrayList<BatteryLogEntity>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("编号.txt"));
        } catch (IOException e) {
            logger.error("汕尾260组.txt 失败", e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (String batteryNo : list) {
            if (StringUtils.isNotBlank(batteryNo)) {
                BatteryLogEntity batteryLogEntity = shareOpStatService.getLastBatteryLog(batteryNo);
                if (batteryLogEntity != null) {
                    log.add(batteryLogEntity);
                }
            }
        }
       /* try {
            EasyExcelUtils.downLoadMultiRowTitle(response, BatteryLogEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
        }*/
        // 输出编号
        System.out.println("有此开始");
        for (BatteryLogEntity batt : log) {
            System.out.println(batt.getBatteryNo() + "    " + batt.getBatteryId());
        }
    }

    /**
     * 根据车牌号导出车辆当前位置
     *
     * @param response
     */
    @RequestMapping("/bike/export")
    public void bikeExport(HttpServletResponse response) {
        String fileName = "多品牌车辆位置导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BikeEntity> log = new ArrayList<BikeEntity>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("佛山130组电池.txt"));
        } catch (IOException e) {
            logger.error("佛山130组电池.txt 失败", e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (String plateNo : list) {
            if (StringUtils.isNotBlank(plateNo)) {
                BikeEntity bike = shareOpStatService.getBikeLocation(plateNo);
                if (bike != null) {
                    //车辆位置
                    if (bike.getLongitude() != null && bike.getLatitude() != null) {
                        String address = AMapUtil.getAddress(String.valueOf(bike.getLongitude()), String.valueOf(bike.getLatitude()));
                        bike.setAddress(address);
                    }
                    log.add(bike);
                }
            }
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, BikeEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据电池编号导出电池当前位置
     *
     * @param response
     */
    @RequestMapping("/batteryAddressExport")
    public void batteryAddressExport(HttpServletResponse response) {
        String fileName = "电池位置导出" + System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BatteryEntity> log = new ArrayList<BatteryEntity>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("南都4822.txt"));
        } catch (IOException e) {
            logger.error("南都4822.txt 失败", e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (String batteryNo : list) {
            if (StringUtils.isNotBlank(batteryNo)) {
                BatteryEntity batteryEntity = shareOpStatService.getLastBatteryAddress(batteryNo);
                if (batteryEntity != null) {
                    //车辆位置
                    if (batteryEntity.getLongitude() != null && batteryEntity.getLatitude() != null) {
                        String address = AMapUtil.getAddress(String.valueOf(batteryEntity.getLongitude()), String.valueOf(batteryEntity.getLatitude()));
                        batteryEntity.setAddress(address);
                    }
                    log.add(batteryEntity);
                }
            }
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, BatteryEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定条件导出车辆当前位置
     *
     * @param response
     */
    @RequestMapping("/bike/address/export")
    public void bikeAddressExport(HttpServletResponse response) {
        String fileName = "多品牌车辆位置导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BikeEntity> log = shareOpStatService.getBikeAddress();
        System.out.println(list.size());
        for (BikeEntity bike : log) {
            //车辆位置
            if (bike.getLongitude() != null && bike.getLatitude() != null) {
                String address = AMapUtil.getAddress(String.valueOf(bike.getLongitude()), String.valueOf(bike.getLatitude()));
                bike.setAddress(address);
            }

        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, BikeEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据电池编号导出电池里程
     *
     * @param response
     */
    @RequestMapping("/battery/accumulate/export")
    public void batteryExport(HttpServletResponse response) {
        String fileName = "电池里程导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BatteryAccumulateEntity> log = new ArrayList<BatteryAccumulateEntity>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("battery_no_list.txt"));
        } catch (IOException e) {
            logger.error("battery_no_list.txt 失败", e);
            e.printStackTrace();
        }
        for (String batteryNo : list) {
            if (StringUtils.isNotBlank(batteryNo)) {
                List<BatteryAccumulateEntity> batteryAccumulateEntityList = shareOpStatService.getbatteryAccumulateEntityList(batteryNo);
                if (batteryAccumulateEntityList != null) {
                    log.addAll(batteryAccumulateEntityList);
                }
            }
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, BatteryAccumulateEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将字符串转换成对象并导出
     * @param response
     */
    @RequestMapping("/testExport")
    public void testExport(HttpServletResponse response) {
        String fileName = "北京十月17人换电工单导出" + System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<OperatorTaskEntity> taskList = new ArrayList<>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("tasktwo.txt"));
        } catch (IOException e) {
            logger.error("换电异常工单导出 失败", e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (String entity : list) {
            if (StringUtils.isNotBlank(entity)) {
                OperatorTaskEntity task = new OperatorTaskEntity();
                List<String> bo = Arrays.asList(entity.split(","));
                for (int i = 0; i < bo.size(); i++) {
                    task.setTaskId(bo.get(0));
                    task.setPlateNo(bo.get(1));
                    task.setUserId(bo.get(2));
                    task.setName(bo.get(3));
                    task.setReceiptBL(bo.get(4));
                    task.setTenBeforeBL(bo.get(5));
                    task.setReceiptTime(bo.get(6));
                    task.setBikeLat(bo.get(7));
                    task.setBikeLng(bo.get(8));
                    task.setAddress(bo.get(9));
                    task.setFinishBikeLat(bo.get(10));
                    task.setFinishBikeLng(bo.get(11));
                    task.setBikeAddress(bo.get(12));
                    task.setAuditTime(bo.get(13));
                    task.setPreChangeTime(bo.get(14));
                    task.setReceiveTime(bo.get(15));
                    task.setGatewayTime(bo.get(16));
                    task.setHasReturnCarIn10(bo.get(17));
                    task.setHasTaskOrderIn10(bo.get(18));
                    task.setHasOpIn10(bo.get(19));
                    task.setBtLevel(bo.get(20));
                    task.setIntervalOrderNum(bo.get(21));
                    task.setIntervalMil(bo.get(22));
                    task.setAttendanceDetailId(bo.get(23));
                    task.setTaskCount(bo.get(24));
                    task.setAbnormal(bo.get(25));
                }
                taskList.add(task);
            }
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, OperatorTaskEntity.class, taskList, fileName, sheetName);
        } catch (IOException e) {
            logger.error("换电异常工单导出失败", e);
        }
    }

    /**
     * 多线程查询数据
     * @return
     */
    public  List<BatteryEntity> test() {
        ThreadUtils<TestService> exportForThreadUtil = new ThreadUtils<TestService>(testService);
        BatteryEntity batteryEntity = new BatteryEntity();
        List<BatteryEntity> list = null;
        try {
            list = exportForThreadUtil.getData(batteryEntity, BatteryEntity.class);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * 将字符串转换成对象并导出
     * @param response
     */
    @RequestMapping("/taskNum")
    public void taskNum(HttpServletResponse response) {
        String fileName = "北京换电工单间隔及蜜豆导出" + System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        String adCode = "110100";
        List<OperatorTaskEntity> taskList = shareOpStatService.getOperatorTaskListNum();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("tasktwo.txt"));
        } catch (IOException e) {
            logger.error("换电异常工单导出 失败", e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for (String entity : list) {
            if (StringUtils.isNotBlank(entity)) {
                OperatorTaskEntity task = new OperatorTaskEntity();
                List<String> bo = Arrays.asList(entity.split(","));
                for (int i = 0; i < bo.size(); i++) {
                    task.setTaskId(bo.get(0));
                    task.setPlateNo(bo.get(1));
                    task.setUserId(bo.get(2));
                    task.setName(bo.get(3));
                    task.setReceiptBL(bo.get(4));
                    task.setTenBeforeBL(bo.get(5));
                    task.setReceiptTime(bo.get(6));
                    task.setBikeLat(bo.get(7));
                    task.setBikeLng(bo.get(8));
                    task.setAddress(bo.get(9));
                    task.setFinishBikeLat(bo.get(10));
                    task.setFinishBikeLng(bo.get(11));
                    task.setBikeAddress(bo.get(12));
                    task.setAuditTime(bo.get(13));
                    task.setPreChangeTime(bo.get(14));
                    task.setReceiveTime(bo.get(15));
                    task.setGatewayTime(bo.get(16));
                    task.setHasReturnCarIn10(bo.get(17));
                    task.setHasTaskOrderIn10(bo.get(18));
                    task.setHasOpIn10(bo.get(19));
                    task.setBtLevel(bo.get(20));
                    task.setIntervalOrderNum(bo.get(21));
                    task.setIntervalMil(bo.get(22));
                    task.setAttendanceDetailId(bo.get(23));
                    task.setTaskCount(bo.get(24));
                    task.setAbnormal(bo.get(25));
                }
                taskList.add(task);
            }
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, OperatorTaskEntity.class, taskList, fileName, sheetName);
        } catch (IOException e) {
            logger.error("换电异常工单导出失败", e);
        }
    }
    /**
     * 根据车牌号导出车辆当前位置
     *
     * @param response
     */
    @RequestMapping("/task/export")
    public void taskExport(HttpServletResponse response) {
        String fileName = "最后调度工单导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<String> plateNoList = new ArrayList<>();
        List<DispatchTaskEntity> log = new ArrayList<DispatchTaskEntity>();
        try {
            list = IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("plateNO.txt"));
        } catch (IOException e) {
            logger.error("plateNO.txt 失败", e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        int i =0;
        for (String plateNo : list) {
            if (StringUtils.isNotBlank(plateNo)) {
                DispatchTaskEntity task = shareOpStatService.getLastDispatchTask(plateNo);
                if (task != null) {
                    task.setOrderStatus("否");
                    if(task.getLastOrderTime() != null){
                        if(task.getLastOrderTime().getTime()>task.getFinishTime().getTime()){
                          task.setOrderStatus("是");
                        }
                    }
                    if(task.getKouYaTime() != null) {
                        task.setKouYaDay(DateUtils.getDateDiffMinute(task.getKouYaTime(), new Date()));
                    }
                    log.add(task);
                    i++;
                    System.out.println(i);
                }else{
                    plateNoList.add(plateNo);
                }
            }
        }
        System.out.println("没有产生调度工单的车牌号"+plateNoList.toString());
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, DispatchTaskEntity.class, log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*   public static void main(String[] args) throws ParseException {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String str =   DateUtils.getDateDiffMinute(sim.parse("2021-01-05 10:10:10"),new Date());
        System.out.println(str);
    }*/



    /**
     * 工单距离导出
     *
     * @param response
     */
    @RequestMapping("/task/juli/export")
    public void taskJuLiExport(HttpServletResponse response) {
        String fileName = "换电工单距离导出";
        String sheetName = "第一个sheet页";
        String startTime = "2021-08-01 00:00:00";
        String endTime = "2021-08-31 23:59:59";
        List<OperatorUsersEntity> userList = shareOpStatService.getUserList(startTime,endTime);
        //List<String> dayList = getDays("2021-09-02","2021-09-04",YYYY_MM_DD);
        List<TaskUserEntity> taskUserList = new ArrayList<>();
        //遍历运维
        for(OperatorUsersEntity user:userList){
            // 遍历日期
            //for(String day :dayList){
                List<TaskUserEntity> taskList = shareOpStatService.getOperatorTaskListByUid(user.getOperatorUsersId(),startTime,endTime);
                if(taskList == null || taskList.size()<=0){
                    continue;
                }
                for (int i =0;i<taskList.size();i++){
                    taskList.get(i).setTaskSubTypeStr(TaskSubTypeEnum.getEnum(taskList.get(i).getTaskSubType()).getDesc());
                    taskList.get(i).setOperatorName(user.getOperatorName());
                    taskList.get(i).setAdName(user.getAdName());
                    taskList.get(i).setMobile(user.getMobile());
                    if(i == 0){
                        taskUserList.add(taskList.get(i));
                        continue;
                    }
                    if (taskList.get(i).getFinishUserLng() != null
                            && taskList.get(i).getFinishUserLng().doubleValue() > 0
                            && taskList.get(i).getFinishUserLat() != null
                            && taskList.get(i).getFinishUserLat().doubleValue() > 0
                            && taskList.get(i - 1).getFinishUserLng() != null
                            && taskList.get(i - 1).getFinishUserLng().doubleValue() > 0
                            && taskList.get(i - 1).getFinishUserLat() != null
                            && taskList.get(i - 1).getFinishUserLat().doubleValue() > 0) {
                        taskList.get(i).setDistance(GpsUtils.getDistance(taskList.get(i).getFinishUserLng().doubleValue(), taskList.get(i).getFinishUserLat().doubleValue(), taskList.get(i - 1).getFinishUserLng().doubleValue(), taskList.get(i - 1).getFinishUserLat().doubleValue()) / 1000);
                        System.out.println("距离上次换电的距离" + taskList.get(i).getDistance());
                    }
                    //taskList.get(i).setTongJiTime(day);
                    taskUserList.add(taskList.get(i));
                }

            //}
            System.out.println("遍历运维"+user.getOperatorName()+"结束"+user.getAdName());
        }
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response, TaskUserEntity.class, taskUserList, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public final static String YYYYMMDD="yyyyMMdd";
    public final static String YYYY_MM_DD="yyyy-MM-dd";

    /**
     *
     * @param startTime  其实日期
     * @param endTime  终止日期
     * @param formatType  日期格式
     * @return
     */
    public static List<String> getDays(String startTime, String endTime ,String formatType) {

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        SimpleDateFormat dateFormat = new SimpleDateFormat(formatType);
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

}
