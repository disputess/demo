package com.example.service.test;

import com.example.domain.entity.TestEntity;
import com.example.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    void getAll() {
        List<TestEntity> all = testService.getAll();
        log.info("name:{}",all.get(0).getName());
        //Assert.assertSame("查询失败",500,testService.getAll());
    }
}