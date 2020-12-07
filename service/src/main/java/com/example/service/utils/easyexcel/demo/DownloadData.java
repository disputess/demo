package com.example.service.utils.easyexcel.demo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
public class DownloadData {
//    @ExcelProperty("字符串标题")
//    private String string;
//    @ExcelProperty("日期标题,你是")
//    private Date date;
//    @ExcelProperty("日期标题,gans")
//    private Double doubleData;

    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "日期标题"})
    private Double doubleData;


    private String mm;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }
}
