package com.example.service.impl;

import com.example.dao.ShareOpStatDao;
import com.example.dao.TestDao;
import com.example.domain.entity.*;
import com.example.service.ShareOpStatService;
import com.example.service.datasources.DataSourceNames;
import com.example.service.datasources.annotation.DataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("shareOpStatService")
public class ShareOpStatServiceImpl implements ShareOpStatService {
    @Autowired
    private ShareOpStatDao shareOpStatDao;

    @Override
    @DataSource(name = DataSourceNames.SHARDING)
    public <T> void insertShareOpStat() {
        for (long i = 1 ; i < 10 ; i++){
            ShareOpStatEntity tableOne = new ShareOpStatEntity() ;
            tableOne.setPhone("phone"+i);
            tableOne.setBackOne("back_one"+i);
            tableOne.setBackTwo("back_two"+i);
            tableOne.setBackThree("back_three"+i);
            tableOne.setShareId(i);
            shareOpStatDao.insertShareOpStat(tableOne);
        }
    }


    @Override
    @DataSource(name = DataSourceNames.SHARDINGTABLE)
    public void insertList() {
        for (int i = 1 ; i < 100 ; i++){
            ShareDatasourcesTableEntity tableOne = new ShareDatasourcesTableEntity() ;
            tableOne.setPhone("phone"+i);
            tableOne.setBackOne("back_one"+i);
            tableOne.setBackTwo("back_two"+i);
            tableOne.setBackThree("back_three"+i);
            tableOne.setShareId(i);
            shareOpStatDao.insertShareDataSourcesTable(tableOne);
        }

    }

    @Override
    @DataSource(name = DataSourceNames.SHARDINGTABLE)
    public List<ShareDatasourcesTableEntity> selectList() {
        return shareOpStatDao.selectList();
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public BatteryLogEntity getLastBatteryLog(String batteryNo) {
        return shareOpStatDao.getLastBatteryLog(batteryNo);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public BikeEntity getBikeLocation(String plateNo) {
        return shareOpStatDao.getBikeLocation( plateNo);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public List<BatteryAccumulateEntity> getbatteryAccumulateEntityList(String batteryNo) {
        return shareOpStatDao.getbatteryAccumulateEntityList(batteryNo);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public BatteryEntity getLastBatteryAddress(String batteryNo) {
        return shareOpStatDao.getLastBatteryAddress(batteryNo);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public List<BikeEntity> getBikeAddress() {
        return shareOpStatDao.getBikeAddress();
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public List<OperatorTaskEntity> importListTask() {
        return shareOpStatDao.importListTask();
    }

    @Override
    public Map<String, Object> getBikePowerIncome(Map<String, Object> param) {
        return shareOpStatDao.getBikePowerIncome(param);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public List<OperatorTaskEntity> getOperatorTaskListNum() {
        return shareOpStatDao.getOperatorTaskListNum();
    }

    @Override
    //@DataSource(name = DataSourceNames.SHARDBIKEING)
    public BikeOpStatEntity getBikeOpListOne(Long bikeId) {
        return shareOpStatDao.getBikeOpListOne(bikeId);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public Long selectBikeIdByPlateNo(String plateNo) {
        return shareOpStatDao.selectBikeIdByPlateNo(plateNo);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public DispatchTaskEntity getLastDispatchTask(String plateNo) {
        return shareOpStatDao.getLastDispatchTask(plateNo);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public List<TaskUserEntity> getOperatorTaskListByUid(Long operatorUsersId, String startTime, String endTime) {
        return shareOpStatDao.getOperatorTaskListByUid(operatorUsersId,startTime,endTime);
    }

    @Override
    @DataSource(name = DataSourceNames.FOUTTH)
    public List<OperatorUsersEntity> getUserList(String startTime, String endTime) {
        return shareOpStatDao.getUserList(startTime,endTime);
    }
}
