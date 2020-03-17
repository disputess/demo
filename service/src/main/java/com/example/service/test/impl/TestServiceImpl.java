package com.example.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.dao.test.TestDao;
import com.example.service.test.TestService;

public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Override
    public List<TestEntity> getAll() {
        return testDao.getAll();
    }
}