package com.example.service;

import com.example.domain.entity.ShareOpStatEntity;
import com.example.service.datasources.DataSourceNames;
import com.example.service.datasources.annotation.DataSource;

/**
 * @author 123
 * @title: ShareOpStatService
 * @projectName demo
 * @description: TODO
 * @date 2020/3/1815:45
 */
public interface ShareOpStatService {
    @DataSource(name = DataSourceNames.SHARDING)
    void insertShareOpStat(ShareOpStatEntity shareOpStatEntity);
}