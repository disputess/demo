package com.example.service.test;

import org.springframework.stereotype.Service;

@Service(value = "testService")
public interface TestService {

    List<TestEntity> getAll();
}
