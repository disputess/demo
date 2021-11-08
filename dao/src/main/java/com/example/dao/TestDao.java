package com.example.dao;

import com.example.domain.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestDao {

    List<TestEntity> getAll();

    List<UsersEntity> changeDatasource();

    void insert(TableOne tableOne);

    void insertShareDataSourcesTable(ShareDatasourcesTableEntity tableOne);

    Long getListCount(@Param("batteryEntity") BatteryEntity batteryEntity);

    List<BatteryEntity> getThreadList(BatteryEntity batteryEntity, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
