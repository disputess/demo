package com.example.service;

import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {

    List<TestEntity> getAll();

    List<UsersEntity> changeDatasource();
}
