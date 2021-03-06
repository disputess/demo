package com.example.dao;

import com.example.domain.entity.ShareDatasourcesTableEntity;
import com.example.domain.entity.TableOne;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {

    List<TestEntity> getAll();

    List<UsersEntity> changeDatasource();

    void insert(TableOne tableOne);

    void insertShareDataSourcesTable(ShareDatasourcesTableEntity tableOne);
}
