package com.example.dao;

import com.example.domain.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {

    List<TestEntity> getAll();
}
