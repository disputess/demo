package com.example.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDto implements Serializable{
    //第几页
    private Integer pageNum = 1;
    //每页几条
    private Integer pageSize = 10;

}
