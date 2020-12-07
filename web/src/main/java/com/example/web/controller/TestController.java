package com.example.web.controller;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.example.common.utils.AMapUtil;
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
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @SysOperatorLog
    @RequestMapping(value = "/getAll")
    public String getAll(Long testId,String testName){
       List<TestEntity> list = new ArrayList<>();
        /*TestEntity test = new TestEntity();
        for(int i = 0;i<10;i++){
            test  = testService.selectOne(testId);
            if(test == null){
              //跳出  break;
            }
            list.add(test) ;
        }*/

       return list.get(0).toString();
   }

    @RequestMapping(value = "/change/datasource")
    public String changeDatasource(){
        List<UsersEntity> list = testService.changeDatasource();
        return list.toString();
    }

    @RequestMapping("/operator/info/export")
    public void operatorInfoExport(HttpServletResponse response) {
        String fileName = "电池最后一条日志导出"+System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BatteryLogEntity> log = new ArrayList<BatteryLogEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("新建文本文档 (3).txt"));
        } catch (IOException e) {
            logger.error("南都4822.txt 失败",e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(String batteryNo:list){
            if(StringUtils.isNotBlank(batteryNo)){
                BatteryLogEntity batteryLogEntity = shareOpStatService.getLastBatteryLog(batteryNo);
                if(batteryLogEntity != null){
                    log.add(batteryLogEntity);
                }
            }
        }
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
      /* try {
            EasyExcelUtils.downLoadMultiRowTitle(response,BatteryLogEntity.class,log, fileName, sheetName);
        } catch (IOException e) {
         }*/
        System.out.println("有此开始");
      for(BatteryLogEntity batt:log){
          System.out.println(batt.getBatteryNo() +"    "+ batt.getBatteryId());

      }
    }

    /*public static void s(String[] args) {

    }
    public static void main(String[] args) {
    }
    public static int test(int x){
    int y = ((x/5-1)*4);
    return y;
    }
*/
    @RequestMapping("/bike/export")
    public void bikeExport(HttpServletResponse response) {
        String fileName = "多品牌车辆位置导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BikeEntity> log = new ArrayList<BikeEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("bike2.txt"));
        } catch (IOException e) {
            logger.error("bike1.txt 失败",e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(String plateNo:list){
            if(StringUtils.isNotBlank(plateNo)){
                BikeEntity bike = shareOpStatService.getBikeLocation(plateNo);
                if(bike != null){
                    //车辆位置
                    if(bike.getLongitude()!=null&&bike.getLatitude()!=null){
                        String address = AMapUtil.getAddress(String.valueOf(bike.getLongitude()), String.valueOf(bike.getLatitude()));
                        bike.setAddress(address);
                    }
                    // System.out.println(batteryLogEntity.getBatteryNo() +"  "+ batteryLogEntity.getOperatorId() +"  "+ batteryLogEntity.getOperatorName() +"  "+ format.format(batteryLogEntity.getCreateTime()) +"  "+ batteryLogEntity.getOperateContent() +"  "+ batteryLogEntity.getRole());
                    log.add(bike);
                }
            }
        }
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response,BikeEntity.class,log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/batteryAddressExport")
    public void batteryAddressExport(HttpServletResponse response) {
        String fileName = "电池位置导出"+System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BatteryEntity> log = new ArrayList<BatteryEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("南都4822.txt"));
        } catch (IOException e) {
            logger.error("南都4822.txt 失败",e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(String batteryNo:list){
            if(StringUtils.isNotBlank(batteryNo)){
                BatteryEntity batteryEntity = shareOpStatService.getLastBatteryAddress(batteryNo);
                if(batteryEntity != null){
                    //车辆位置
                    if(batteryEntity.getLongitude()!=null&&batteryEntity.getLatitude()!=null){
                        String address = AMapUtil.getAddress(String.valueOf(batteryEntity.getLongitude()), String.valueOf(batteryEntity.getLatitude()));
                        batteryEntity.setAddress(address);
                    }
                    log.add(batteryEntity);
                }
            }
        }
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response,BatteryEntity.class,log, fileName, sheetName);
        } catch (IOException e) {
        }
       /* System.out.println("有此开始");
      for(BatteryLogEntity batt:log){
          System.out.println(batt.getBatteryNo() +"    "+ batt.getBatteryId());

      }*/
    }
    @RequestMapping("/bike/address/export")
    public void bikeAddressExport(HttpServletResponse response) {
        String fileName = "多品牌车辆位置导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BikeEntity> log = shareOpStatService.getBikeAddress();
       /* try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("bike2.txt"));
        } catch (IOException e) {
            logger.error("bike1.txt 失败",e);
            e.printStackTrace();
        }*/
        System.out.println(list.size());
        for (BikeEntity bike : log) {
            //车辆位置
            if (bike.getLongitude() != null && bike.getLatitude() != null) {
                String address = AMapUtil.getAddress(String.valueOf(bike.getLongitude()), String.valueOf(bike.getLatitude()));
                bike.setAddress(address);
            }

        }
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response,BikeEntity.class,log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/battery/accumulate/export")
    public void batteryExport(HttpServletResponse response) {
        String fileName = "电池里程导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
        List<BatteryAccumulateEntity> log = new ArrayList<BatteryAccumulateEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("battery_no_list.txt"));
        } catch (IOException e) {
            logger.error("battery_no_list.txt 失败",e);
            e.printStackTrace();
        }
        for(String batteryNo:list){
            if(StringUtils.isNotBlank(batteryNo)){
                List<BatteryAccumulateEntity> batteryAccumulateEntityList = shareOpStatService.getbatteryAccumulateEntityList(batteryNo);
                if(batteryAccumulateEntityList != null){
                    log.addAll(batteryAccumulateEntityList);
                }
            }
        }
        System.out.println(log.size());
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        try {
            EasyExcelUtils.downLoadMultiRowTitle(response,BatteryAccumulateEntity.class,log, fileName, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@RequestMapping("/taskDetailsExport")
    public void taskDetailsExport(HttpServletResponse response) {
        String fileName = "工单详情导出" + System.currentTimeMillis();
        String sheetName = "第一个sheet页";
        List<OperatorTaskEntity> list = shareOpStatService.importListTask();
        Map<String, Object> param = null;
        for (OperatorTaskEntity bo : list) {
            String bikeStatusStr = "";
            //车辆状态
            if (bo.getBikeStatus() != null) {
                int bikeStatus = bo.getBikeStatus().intValue();
                bikeStatusStr = BikeStateEnum.getEnumMap().get(bikeStatus);
            }
            String assignTypeStr = "";
            int assignType = bo.getAssignType().intValue();
                if (assignType == 1) {
                    assignTypeStr = "抢单";
                } else if (assignType == 2) {
                    assignTypeStr = "派单";
                }

            //工单类型
                String taskTypeStr = "";
                int taskType = bo.getTaskType().intValue();
                taskTypeStr = TaskTypeEnum.getEnum(taskType).getDesc();

            //子类型
            String taskSubtypeStr = "";
            int tasksubType = bo.getTaskSubtype().intValue();
            taskSubtypeStr = TaskSubTypeEnum.getEnum(tasksubType).getDesc();

            //审核状态
            String taskStatusStr = "";

                int processStatus = bo.getProcessStatus().intValue();
                int auditStatus = bo.getAuditStatus().intValue();
                taskStatusStr = getTaskStatusStr(processStatus, auditStatus);

            //工单取消原因
                 String taskCancelStr = "";

                Integer taskCancelType = bo.getTaskCancelType();
                if (taskCancelType.intValue() == 0) {
                    taskCancelStr = "";
                } else {
                    taskCancelStr = OperatorTaskCancelTypeEnum.getEnum(taskCancelType).getDesc();
                }


            bo.setBikeStatusStr(bikeStatusStr);
            bo.setAssignTypeStr(assignTypeStr);
            bo.setTaskTypeStr(taskTypeStr);
            bo.setTaskSubtypeStr(taskSubtypeStr);
            bo.setTaskStatusStr(taskStatusStr);
            param = new HashMap<>();
            param.put("operatorTaskId", bo.getOperatorTaskId());
            param.put("incomeType", bo.getTaskType());
            Map<String, Object> map = shareOpStatService.getBikePowerIncome(param);
            if (null != map) {
                bo.setIntervalOrderNum(null != map.get("intervalOrderNum") ? Long.valueOf(map.get("intervalOrderNum").toString()) : 0L);
                bo.setIntervalAmount(null != map.get("intervalAmount") ? new BigDecimal(map.get("intervalAmount").toString()) : BigDecimal.ZERO);
                if (null != map.get("preChangeTime")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        bo.setPreChangeTime(sdf.format(sdf.parse(map.get("preChangeTime").toString())));
                        String dateDiff = DateUtils.getDateDiffMinute(sdf.parse(map.get("preChangeTime").toString()), bo.getCreateTime());
                        if (StringUtils.isNotBlank(dateDiff)) {
                            bo.setPreChangeTime(dateDiff);
                        }

                    } catch (Exception e) {
                        logger.error("上次换电时间转换出错", e);
                    }
                }
                bo.setIntervalMil(null != map.get("intervalMil") ? new BigDecimal(map.get("intervalMil").toString()) : BigDecimal.ZERO);

            }
        }
        try {
        EasyExcelUtils.downLoadMultiRowTitle(response, OperatorTaskEntity.class, list, fileName, sheetName);
    } catch (IOException e) {
    }



    }

    private String getTaskStatusStr(int processStatus, int auditStatus) {
        String taskStatusStr = "";
        if (processStatus == 4 && auditStatus == 0) {
            taskStatusStr = "已取消";
        } else if (processStatus == 1 && auditStatus == 0) {
            taskStatusStr = "已派单";
        } else if (processStatus == 2 && auditStatus == 0) {
            taskStatusStr = "进行中";
        } else if (processStatus == 3 && auditStatus == 0) {
            taskStatusStr = "待审核";
        } else if (processStatus == 3 && auditStatus == 1) {
            taskStatusStr = "审核通过";
        } else if (processStatus == 3 && auditStatus == 2) {
            taskStatusStr = "审核不通过";
        }
        return taskStatusStr;
    }*/


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
        for (String batteryNo : list) {
            if (StringUtils.isNotBlank(batteryNo)) {
                OperatorTaskEntity task = new OperatorTaskEntity();
                List<String> bo = Arrays.asList(batteryNo.split(","));
                for(int i = 0;i<bo.size();i++){
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
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可

}
