package com.example.dao.test;

import com.example.domain.test.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {

    List<TestEntity> getAll();
}
