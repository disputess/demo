package com.example.service.impl;

import com.example.domain.entity.ShareOpStatEntity;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import com.example.service.ShareOpStatService;
import com.example.service.datasources.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dao.TestDao;
import com.example.service.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Autowired
    private ShareOpStatService shareOpStatService;
    @Override
    public List<TestEntity> getAll() {
        return testDao.getAll();
    }

    @Override
    public List<UsersEntity> changeDatasource() {
        List<UsersEntity> list  =new ArrayList<>();
        try {
            DynamicDataSource.setDataSource("second");
            list = testDao.changeDatasource();
        } catch (Exception e) {
            System.out.println("根据车辆{},车型查询配套配件异常{}"+ e);
        } finally {
            DynamicDataSource.clearDataSource();
        }
        return list;
    }

    @Override
    public void test(ShareOpStatEntity shareOpStatEntity) {
        System.out.println("shareOpStatEntity = [" + shareOpStatEntity.toString() + "]");
        shareOpStatService.insertShareOpStat(shareOpStatEntity);
    }
}
