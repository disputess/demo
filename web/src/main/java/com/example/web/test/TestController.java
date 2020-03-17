package com.example.web.test;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.test.entity.TestEntity;
import com.example.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tset")
public class TestController {

//    @Resource
//    private TestService testService;
//
//    @RequestMapping(value = "/getAll")
//    public String getAll(){
//        List<TestEntity> list = testService.getAll();
//        return list.get(0).toString();
//    }

}
