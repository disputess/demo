package com.example.service.impl;

import com.example.domain.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dao.TestDao;
import com.example.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Override
    public List<TestEntity> getAll() {
        return testDao.getAll();
    }
}
