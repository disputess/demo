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
public class DispatchTaskEntity implements Serializable {

	@ExcelProperty(value = "车牌号" ,index = 0)
	private String plateNo;
	@ExcelProperty(value = "完成时间" ,index = 1)
	private Date finishTime;
	@ExcelProperty(value = "完成人" ,index = 2)
	private String operatorName;
	@ExcelProperty(value = "扣押时间" ,index = 3)
	private Date kouYaTime;
	@ExcelProperty(value = "扣押间隔时长" ,index = 4)
	private String kouYaDay;
	@ExcelProperty(value = "最后订单时间" ,index = 5)
	private Date lastOrderTime;
	@ExcelProperty(value = "调度后是否产生订单" ,index = 6)
	private String orderStatus;

}
