package com.example.domain.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BikeOpStatEntity implements Serializable {
    @ExcelProperty(value = "bikeId" ,index = 0)
    private Long bikeId;
    @ExcelProperty(value = "车牌号" ,index = 1)
    private String plateNo;
    @ExcelProperty(value = "操作人Id" ,index = 2)
    private Long operatorId;
    @ExcelProperty(value = "操作人" ,index = 3)
    private String operatorName;
    @ExcelProperty(value = "操作人角色类型" ,index = 4)
    private Integer operatorType;
    @ExcelProperty(value = "操作时间" ,index = 5)
    private Date operationTime;
    @ExcelProperty(value = "操作类型" ,index = 6)
    private Integer operationType;
    @ExcelProperty(value = "扩展内容" ,index = 7)
    private String extra;
    @ExcelProperty(value = "操作内容" ,index = 8)
    private String content;

}
