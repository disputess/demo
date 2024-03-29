package com.example.domain.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class TestEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
