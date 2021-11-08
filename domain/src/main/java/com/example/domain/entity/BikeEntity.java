package com.example.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电池操作日志表
 * 
 * @author songchaojie
 * @email songchaojie@gmail.com
 * @date 2018-06-16 17:36:48
 */
@Data
public class BikeEntity implements Serializable {


	/**
	 * 车牌号
	 */
	@ExcelProperty(value = "车牌号" ,index = 0)
	private String plateNo;
	/**
	 * 经度
	 */
	@ExcelProperty(value = "经度" ,index = 1)
	private Double longitude;
	/**
	 * 纬度
	 */
	@ExcelProperty(value = "纬度" ,index = 2)
	private Double latitude;
	@ExcelProperty(value = "地址" ,index = 3)
	private String address;
	@ExcelProperty(value = "时间" ,index = 4)
	private Date createTime;
	@ExcelProperty(value = "时间2" ,index = 5)
	private Date updateTime;

}
