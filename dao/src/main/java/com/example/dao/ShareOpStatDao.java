package com.example.dao;

import com.example.domain.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShareOpStatDao {
    void insertShareOpStat(ShareOpStatEntity shareOpStatEntity);

    void insertShareDataSourcesTable(ShareDatasourcesTableEntity tableOne);

    List<ShareDatasourcesTableEntity> selectList();

//    BatteryLogEntity getLastBatteryLog(@Param("batteryNo") String batteryNo);
//
//    BikeEntity getBikeLocation(@Param("plateNo")String plateNo);
//
//    List<BatteryAccumulateEntity> getbatteryAccumulateEntityList(@Param("batteryNo") String batteryNo);
}
