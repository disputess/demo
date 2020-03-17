package com.example.dao.test;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    List<TestEntity> getAll();
}
