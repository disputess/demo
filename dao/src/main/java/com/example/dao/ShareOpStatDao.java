package com.example.dao;

import com.example.domain.entity.ShareOpStatEntity;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShareOpStatDao {
    void insertShareOpStat(ShareOpStatEntity shareOpStatEntity);
}
