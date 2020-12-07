package com.example.service.utils.easyexcel.coverdemo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;

/**
 * @Auther: YUANEL
 * @Date: 2019/10/9 18:07
 * @Description:
 * 自定义转换demo  这里只是一个demo
 * （具体的实现根据业务来自定义实现）
 */
public class ConverterDataDemo {

    /**
     * 自定义 转换器，不管数据库传过来什么 。我给他加上“自定义：”
     */
    @ExcelProperty(converter = CustomStringStringConverterDemo.class)
    private String string;
    /**
     * 这里用string 去接日期才能格式化。我想接收年月日格式
     */
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private String date;
    /**
     * 我想接收百分比的数字
     */
    @NumberFormat("#.##%")
    private String doubleData;



}
