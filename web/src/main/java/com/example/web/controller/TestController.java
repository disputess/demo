package com.example.web.controller;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import com.example.service.ShareOpStatService;
import com.example.service.TestService;
import com.example.web.annotation.SysOperatorLog;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
       List<TestEntity> list = testService.getAll();
       return list.get(0).toString();
   }

    @RequestMapping(value = "/change/datasource")
    public String changeDatasource(){
        List<UsersEntity> list = testService.changeDatasource();
        return list.toString();
    }
    @RequestMapping(value = "/share/table")
    public void shareTable(){

            ShareOpStatEntity  shareOpStatEntity = new ShareOpStatEntity();
            shareOpStatEntity.setUid(System.currentTimeMillis());
            shareOpStatEntity.setShareId(55L);
            shareOpStatEntity.setName("徐辣鸡");
            testService.test(shareOpStatEntity);
            shareOpStatService.insertShareOpStat(shareOpStatEntity);

        logger.info("分表成功");
    }
    @RequestMapping(value = "/create/table")
    public void createTable(){
        testService.createTable();

        logger.info("建表成功");
    }
    @RequestMapping(value = "/insert/List")
    public void insertList(){
        testService.insertList();
        logger.info("建表成功");
    }
    public static void main(String[] args) {
        /*String str = "11111zhongZ.";
        Pattern pattern = Pattern.compile(REGEX);
        if (!pattern.matcher(str).matches()){
            System.out.println("正则效验未通过!");
        }*/
        String mobile=    mobileEncrypt("17610838270");
        System.out.println(mobile);
    }
    public static String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
}
