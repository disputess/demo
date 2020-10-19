package com.example.web.controller;
import com.alibaba.excel.EasyExcel;
//import com.example.common.utils.AMapUtil;
import com.example.domain.entity.*;
import com.example.service.ShareOpStatService;
import com.example.service.TestService;
//import com.example.service.utils.easyexcel.EasyExcelUtils;
import com.example.web.annotation.SysOperatorLog;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
//        List<BatteryLogEntity> log = new ArrayList<BatteryLogEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("电池日志.txt"));
        } catch (IOException e) {
            logger.error("battery_log_07_28.txt 失败",e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(String batteryNo:list){
            if(StringUtils.isNotBlank(batteryNo)){
//                BatteryLogEntity batteryLogEntity = shareOpStatService.getLastBatteryLog(batteryNo);
//                if(batteryLogEntity != null){
//                    log.add(batteryLogEntity);
//                }
            }
        }
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
//       try {
//            EasyExcelUtils.downLoadMultiRowTitle(response,BatteryLogEntity.class,log, fileName, sheetName);
//        } catch (IOException e) {
//         }
       /* System.out.println("有此开始");
      for(BatteryLogEntity batt:log){
          System.out.println(batt.getBatteryNo() +"    "+ batt.getBatteryId());

      }*/
    }

    public static void main(String[] args) {
        System.out.println(4680+4333.83+319.7-3441.24);
    }


    @RequestMapping("/bike/export")
    public void bikeExport(HttpServletResponse response) {
        String fileName = "多品牌车辆位置导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
//        List<BikeEntity> log = new ArrayList<BikeEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("bike2.txt"));
        } catch (IOException e) {
            logger.error("bike1.txt 失败",e);
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(String plateNo:list){
//            if(StringUtils.isNotBlank(plateNo)){
//                BikeEntity bike = shareOpStatService.getBikeLocation(plateNo);
//                if(bike != null){
//                    //车辆位置
//                    if(bike.getLongitude()!=null&&bike.getLatitude()!=null){
//                        String address = AMapUtil.getAddress(String.valueOf(bike.getLongitude()), String.valueOf(bike.getLatitude()));
//                        bike.setAddress(address);
//                    }
//                    // System.out.println(batteryLogEntity.getBatteryNo() +"  "+ batteryLogEntity.getOperatorId() +"  "+ batteryLogEntity.getOperatorName() +"  "+ format.format(batteryLogEntity.getCreateTime()) +"  "+ batteryLogEntity.getOperateContent() +"  "+ batteryLogEntity.getRole());
//                    log.add(bike);
//                }
//            }
        }
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
//        try {
//            EasyExcelUtils.downLoadMultiRowTitle(response,BikeEntity.class,log, fileName, sheetName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



    @RequestMapping("/battery/accumulate/export")
    public void batteryExport(HttpServletResponse response) {
        String fileName = "电池里程导出";
        String sheetName = "第一个sheet页";
        List<String> list = new ArrayList<>();
//        List<BatteryAccumulateEntity> log = new ArrayList<BatteryAccumulateEntity>();
        try {
            list= IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("battery_no_list.txt"));
        } catch (IOException e) {
            logger.error("battery_no_list.txt 失败",e);
            e.printStackTrace();
        }
        for(String batteryNo:list){
            if(StringUtils.isNotBlank(batteryNo)){
//                List<BatteryAccumulateEntity> batteryAccumulateEntityList = shareOpStatService.getbatteryAccumulateEntityList(batteryNo);
//                if(batteryAccumulateEntityList != null){
//                    log.addAll(batteryAccumulateEntityList);
//                }
            }
        }
//        System.out.println(log.size());
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
//        try {
//            EasyExcelUtils.downLoadMultiRowTitle(response,BatteryAccumulateEntity.class,log, fileName, sheetName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
