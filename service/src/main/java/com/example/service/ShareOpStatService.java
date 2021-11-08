package com.example.service;

import com.example.domain.entity.*;
import com.example.service.datasources.DataSourceNames;
import com.example.service.datasources.annotation.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 123
 * @title: ShareOpStatService
 * @projectName demo
 * @description: TODO
 * @date 2020/3/1815:45
 */
public interface ShareOpStatService {
    @DataSource(name = DataSourceNames.SHARDING)
    <T> void insertShareOpStat(ShareOpStatEntity shareOpStatEntity);
    @DataSource(name = DataSourceNames.SHARDINGTABLE)
    void insertList();
    @DataSource(name = DataSourceNames.SHARDINGTABLE)
    List<ShareDatasourcesTableEntity> selectList();
    @DataSource(name = DataSourceNames.FOUTTH)
    BatteryLogEntity getLastBatteryLog(String batteryNo);
    @DataSource(name = DataSourceNames.FOUTTH)
    BikeEntity getBikeLocation(String plateNo);
    @DataSource(name = DataSourceNames.FOUTTH)
    List<BatteryAccumulateEntity> getbatteryAccumulateEntityList(String batteryNo);
    @DataSource(name = DataSourceNames.FOUTTH)
    BatteryEntity getLastBatteryAddress(String batteryNo);
    @DataSource(name = DataSourceNames.FOUTTH)
    List<BikeEntity> getBikeAddress();
    @DataSource(name = DataSourceNames.FOUTTH)
    List<OperatorTaskEntity> importListTask();
    @DataSource(name = DataSourceNames.FOUTTH)
    Map<String,Object> getBikePowerIncome(Map<String, Object> param);
    @DataSource(name = DataSourceNames.FOUTTH)
    List<OperatorTaskEntity> getOperatorTaskListNum();
    @DataSource(name = DataSourceNames.SHARDBIKEING)
    BikeOpStatEntity getBikeOpListOne(Long bikeId);
    @DataSource(name = DataSourceNames.FOUTTH)
    Long selectBikeIdByPlateNo(String plateNo);
    @DataSource(name = DataSourceNames.FOUTTH)
    DispatchTaskEntity getLastDispatchTask(String plateNo);
    @DataSource(name = DataSourceNames.FOUTTH)
    List<TaskUserEntity> getOperatorTaskListByUid(Long operatorUsersId, String startTime, String endTime);
    @DataSource(name = DataSourceNames.FOUTTH)
    List<OperatorUsersEntity> getUserList(String startTime, String endTime);
}
