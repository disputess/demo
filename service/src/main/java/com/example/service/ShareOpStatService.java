package com.example.service;

import com.example.domain.entity.ShareDatasourcesTableEntity;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.service.datasources.DataSourceNames;
import com.example.service.datasources.annotation.DataSource;

import java.util.List;

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
}
