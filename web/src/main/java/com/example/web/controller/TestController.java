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


    public static void main(String[] args) {
        System.out.println((float)(((10/3)*8)*((10/3)*8))/(((10/3)*6)*((10/3)*6)));
    }
}
