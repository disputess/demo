package com.example.service.impl;

import com.example.dao.ShareOpStatDao;
import com.example.dao.TestDao;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.service.ShareOpStatService;
import com.example.service.datasources.DataSourceNames;
import com.example.service.datasources.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shareOpStatService")
public class ShareOpStatServiceImpl implements ShareOpStatService {
    @Autowired
    private ShareOpStatDao shareOpStatDao;

    @Override
    @DataSource(name = DataSourceNames.SHARDING)
    public <T> void insertShareOpStat(ShareOpStatEntity shareOpStatEntity) {
        shareOpStatDao.insertShareOpStat(shareOpStatEntity);
    }
}
