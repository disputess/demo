package com.example.service.test;

import com.example.domain.test.entity.TestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "testService")
public interface TestService {

    List<TestEntity> getAll();
}
