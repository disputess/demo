package com.example.domain.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TaskUserEntity {

	/**
	 * 电池编号
	 */
	@ExcelProperty(value = "地勤姓名" ,index = 0)
	private String operatorName;
	/**
	 * 经度
	 */
	@ExcelProperty(value = "地勤城市" ,index = 1)
	private String adName;
	/**
	 * 纬度
	 */
	@ExcelProperty(value = "工单id" ,index = 2)
	private Long taskId;
	@ExcelProperty(value = "任务类型" ,index = 3)
	private String taskSubTypeStr;
	@ExcelProperty(value = "和上次换电之间的距离(公里)" ,index = 4)
	private Double distance;
	@ExcelProperty(value = "任务完成时间" ,index = 5)
	private Date finishTime;
	@ExcelProperty(value = "统计日期" ,index = 6)
	private String tongJiTime;
	@ExcelIgnore
	private BigDecimal finishUserLat;
	@ExcelIgnore
	private BigDecimal finishUserLng;
	@ExcelIgnore
	private Integer taskSubType;
	@ExcelProperty(value = "地勤电话" ,index = 7)
	private String mobile;
	@ExcelProperty(value = "车辆编号" ,index = 8)
	private String plateNo;
	@ExcelProperty(value = "接单时间" ,index = 9)
	private Date receiptTime;
	@ExcelProperty(value = "审核时间" ,index = 10)
	private Date auditTime;
	@ExcelProperty(value = "审核状态" ,index = 11)
	private String auditStatusStr;
	@ExcelProperty(value = "工单来源" ,index = 12)
	private String taskFrom;
	@ExcelProperty(value = "工单状态" ,index = 13)
	private String processStatusStr;





}
