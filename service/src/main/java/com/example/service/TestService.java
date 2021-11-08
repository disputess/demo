package com.example.service;

import com.example.domain.entity.BatteryEntity;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService extends ThreadUtilsService<BatteryEntity> {

    List<TestEntity> getAll();

    List<UsersEntity> changeDatasource();

    void test(ShareOpStatEntity shareOpStatEntity);

    void createTable();

    void insertList();
}
