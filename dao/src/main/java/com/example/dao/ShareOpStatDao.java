package com.example.dao;

import com.example.domain.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShareOpStatDao {
    void insertShareOpStat(ShareOpStatEntity shareOpStatEntity);

    void insertShareDataSourcesTable(ShareDatasourcesTableEntity tableOne);

    List<ShareDatasourcesTableEntity> selectList();

    BatteryLogEntity getLastBatteryLog(@Param("batteryNo") String batteryNo);

    BikeEntity getBikeLocation(@Param("plateNo")String plateNo);

    List<BatteryAccumulateEntity> getbatteryAccumulateEntityList(@Param("batteryNo") String batteryNo);

    BatteryEntity getLastBatteryAddress(@Param("batteryNo") String batteryNo);

    List<BikeEntity> getBikeAddress();

    List<OperatorTaskEntity> importListTask();

    Map<String,Object> getBikePowerIncome(Map<String, Object> param);
}
