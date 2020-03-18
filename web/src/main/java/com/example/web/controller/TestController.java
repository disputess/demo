package com.example.web.controller;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @RequestMapping(value = "/getAll")
   public String getAll(){
       List<TestEntity> list = testService.getAll();
       return list.get(0).toString();
   }

    @RequestMapping(value = "/change/datasource")
    public String changeDatasource(){
        List<UsersEntity> list = testService.changeDatasource();
        return list.toString();
    }

}
