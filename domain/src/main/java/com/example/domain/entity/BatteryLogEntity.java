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
public class BatteryLogEntity implements Serializable {

	/**
	 * 
	 */
	@ExcelProperty(value = "id" ,index = 0)
	private Long id;

	private Long batteryId;
	/**
	 * 电池编号
	 */
	@ExcelProperty(value = "电池编号" ,index = 1)
	private String batteryNo;
	/**
	 * 操作人id
	 */
	@ExcelProperty(value = "操作人id" ,index = 2)
	private Long operatorId;
	/**
	 * 操作人姓名
	 */
	@ExcelProperty(value = "操作人姓名" ,index = 3)
	private String operatorName;
	/**
	 * 创建时间
	 */
	@ExcelProperty(value = "创建时间" ,index = 4)
	private Date createTime;
	/**
	 * 操作内容
	 */
	@ExcelProperty(value = "操作内容" ,index = 5)
	private String operateContent;
	/**
	 * 0 其他 1 电池录入 3 电池绑定车辆 5 卡车发电池 7 库管入库 9 库管出库 11  安装电池 13 车辆中取下电池 15 上报丢失
	 */
	@ExcelProperty(value = "操作类型" ,index = 6)
	private Integer operateType;
	/**
	 * 角色
	 */
	@ExcelProperty(value = "操作人角色" ,index = 7)
	private String role;


}
