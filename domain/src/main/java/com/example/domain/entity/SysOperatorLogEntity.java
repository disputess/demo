package com.example.domain.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 * 
 * @author xukaisheng
 * @date 2018-06-14 16:38:16
 */
public class SysOperatorLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private Long id;
	/**
	 * 操作人id
	 */
	private Long operatorId;
	/**
	 * 操作人
	 */
	private String operatorName;
	/**
	 * 用户操作类型
	 */
	private Integer operatorType;
	/**
	 * 操作内容
	 */
	private String operatorContent;
	/**
	 * 操作时间
	 */
	private Date operatorTime;
	/**
	 * 用户操作
	 */
	private String operate;
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求参数
	 */
	private String params;
	/**
	 * 执行时长(毫秒)
	 */
	private Long time;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：操作人id
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 获取：操作人id
	 */
	public Long getOperatorId() {
		return operatorId;
	}
	/**
	 * 设置：操作人
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**
	 * 获取：操作人
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 设置：用户操作类型
	 */
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}
	/**
	 * 获取：用户操作类型
	 */
	public Integer getOperatorType() {
		return operatorType;
	}
	/**
	 * 设置：操作内容
	 */
	public void setOperatorContent(String operatorContent) {
		this.operatorContent = operatorContent;
	}
	/**
	 * 获取：操作内容
	 */
	public String getOperatorContent() {
		return operatorContent;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getOperatorTime() {
		return operatorTime;
	}
	/**
	 * 设置：用户操作
	 */
	public void setOperate(String operate) {
		this.operate = operate;
	}
	/**
	 * 获取：用户操作
	 */
	public String getOperate() {
		return operate;
	}
	/**
	 * 设置：请求方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：请求方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：请求参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：请求参数
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：执行时长(毫秒)
	 */
	public void setTime(Long time) {
		this.time = time;
	}
	/**
	 * 获取：执行时长(毫秒)
	 */
	public Long getTime() {
		return time;
	}
}
