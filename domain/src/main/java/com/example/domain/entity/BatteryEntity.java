package com.example.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电池表
 * 
 * @author songchaojie
 * @email songchaojie@gmail.com
 * @date 2018-06-16 17:36:48
 */
@Data
public class BatteryEntity extends BaseDto {

	/**
	 * 电池编号
	 */
	@ExcelProperty(value = "电池编号" ,index = 0)
	private String batteryNo;
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
	@ExcelProperty(value = "电池信息最后更新时间" ,index = 4)
	private Date modifyTime;
	@ExcelProperty(value = "网关上报定位时间" ,index = 5)
	private String gatewayTime;
	@ExcelProperty(value = "电池最后定位时间" ,index = 6)
	private String gpsTime;


}
