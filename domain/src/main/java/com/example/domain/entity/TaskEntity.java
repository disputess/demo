package com.example.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 电池表
 * 
 * @author songchaojie
 * @email songchaojie@gmail.com
 * @date 2018-06-16 17:36:48
 */
@Data
public class TaskEntity implements Serializable {

	private Long taskId;
	private Long userId;
	@ExcelProperty(value = "姓名" ,index = 3)
	private String name;
	@ExcelProperty(value = "接单时电量" ,index = 4)
	String receiptBL;
	@ExcelProperty(value = "接单前电量" ,index = 5)
	String tenBeforeBL;
	@ExcelProperty(value = "接单时间" ,index = 6)
	private String receiptTime;
	/**接单时车辆维度*/
	@ExcelProperty(value = "接单纬度" ,index = 7)
	private String bikeLat;
	/**接单时车辆经度*/
	@ExcelProperty(value = "接单经度" ,index = 8)
	private String bikeLng;
	@ExcelProperty(value = "地址" ,index = 9)
	private String address;
	@ExcelProperty(value = "完成纬度" ,index = 10)
	private String finishBikeLat;
	@ExcelProperty(value = "完成经度" ,index = 11)
	private String finishBikeLng;
	/**接单时车辆地址*/
	@ExcelProperty(value = "完成地址" ,index = 12)
	private String bikeAddress;
	@ExcelProperty(value = "审核时间" ,index = 13)
	private String auditTime;
	@ExcelProperty(value = "上次换电时间" ,index = 14)
	private String preChangeTime;
	@ExcelProperty(value = "接车时间" ,index = 15)
	private String receiveTime;

	@ExcelProperty(value = "网关时间" ,index = 16)
	String gatewayTime;
	/**
	 * 10分钟内是否有还车记录
	 */
	@ExcelProperty(value = "10分钟前有还车" ,index = 17)
	String hasReturnCarIn10;
	/**
	 * 10分钟内是否有完成工单记录
	 */
	@ExcelProperty(value = "10分钟前有工单" ,index = 18)
	String hasTaskOrderIn10;

	/**
	 * 10分钟内是否有启动、设防操作记录
	 */
	@ExcelProperty(value = "10分钟前有启动设防" ,index = 19)
	String hasOpIn10;

	@ExcelProperty(value = "电量均值" ,index = 20)
	String btLevel;
	@ExcelProperty(value = "间隔订单" ,index = 21)
	private String intervalOrderNum;
	@ExcelProperty(value = "间隔里程" ,index = 22)
	private String intervalMil;
	@ExcelProperty(value = "出勤单" ,index = 23)
	private String attendanceDetailId;
	@ExcelProperty(value = "任务数" ,index = 24)
	private String taskCount;
	@ExcelProperty(value = "是否为异常工单" ,index = 25)
	private String abnormal;

	/**
	 *   工单结束时人所处纬度
	 * Column: operator_task.finish_user_lat
	 @mbggenerated 2018-06-30 16:46:06
	 */
	private BigDecimal finishUserLat;

	/**
	 *   工单结束时人所处经度
	 * Column: operator_task.finish_user_lng
	 @mbggenerated 2018-06-30 16:46:06
	 */
	private BigDecimal finishUserLng;






}
