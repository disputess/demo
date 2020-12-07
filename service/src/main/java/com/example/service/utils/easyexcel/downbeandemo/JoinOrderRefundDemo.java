package com.example.service.utils.easyexcel.downbeandemo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * @Auther: YUANEL
 * @Date: 2019/11/12 14:15
 * @Description:
 */
public class JoinOrderRefundDemo {
    @ExcelProperty({"加盟信息", "姓名"})
    private String realName;
    @ExcelProperty({"加盟信息", "手机号"})
    private String mobile;
    @ExcelProperty({"加盟信息", "所属城市"})
    private String cityName;
    @ExcelProperty({"加盟信息", "订单号"})
    private String orderNo;
    @ExcelProperty({"加盟信息", "加盟时间"})
    private String joinCreateTime;
    @ExcelProperty({"加盟信息", "加盟金额"})
    private BigDecimal orderAmount;
    @ExcelProperty({"加盟信息", "支付时间"})
    private String payTime;
    @ExcelProperty({"加盟信息", "申请出售时间"})
    private String applySellTime;
    @ExcelProperty({"加盟信息", "运营结束时间"})
    private String joinEndTime;
    @ExcelProperty({"加盟信息", "支付方式"})
    private String payDesc;
    @ExcelProperty({"加盟信息", "付款app"})
    private String payAppDesc;
    @ExcelProperty({"加盟信息", "商户订单号"})
    private String outTradeNo;


    @ExcelProperty({"收租信息", "已收到租金"})
    private BigDecimal profitTotalAmount;
    @ExcelProperty({"收租信息", "已提现金额"})
    private BigDecimal withdrawAmount;

    @ExcelProperty({"退款信息", "违约扣除"})
    private BigDecimal defaultAmount;
    @ExcelProperty({"退款信息", "退款扣除"})
    private BigDecimal refundAmount;
    @ExcelProperty({"退款信息", "收益需转账金额"})
    private BigDecimal incomeTransferAmount;
    @ExcelProperty({"退款信息", "支付总金额"})
    private BigDecimal totalPayAmount;

    @ExcelProperty({"回访信息", "转账支付宝或微信账号"})
    private String transferAccountNumber;
    @ExcelProperty({"回访信息", "电话回访"})
    private String mobileReturnVisit;
    @ExcelProperty({"回访信息", "备注"})
    private String remark;


    @ExcelProperty({"回购信息", "回购时间"})
    private String refundTime;
    @ExcelProperty({"回购信息", "回购总金额"})
    private BigDecimal refundMoney;
    @ExcelProperty({"回购信息", "回购原因"})
    private String sellReason;
    @ExcelProperty({"回购信息", "回购款转账渠道"})
    private String refundNameChannelNo;

    public String getJoinEndTime() {
        return joinEndTime;
    }

    public void setJoinEndTime(String joinEndTime) {
        this.joinEndTime = joinEndTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getJoinCreateTime() {
        return joinCreateTime;
    }

    public void setJoinCreateTime(String joinCreateTime) {
        this.joinCreateTime = joinCreateTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public String getPayAppDesc() {
        return payAppDesc;
    }

    public void setPayAppDesc(String payAppDesc) {
        this.payAppDesc = payAppDesc;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getProfitTotalAmount() {
        return profitTotalAmount;
    }

    public void setProfitTotalAmount(BigDecimal profitTotalAmount) {
        this.profitTotalAmount = profitTotalAmount;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public BigDecimal getDefaultAmount() {
        return defaultAmount;
    }

    public void setDefaultAmount(BigDecimal defaultAmount) {
        this.defaultAmount = defaultAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getIncomeTransferAmount() {
        return incomeTransferAmount;
    }

    public void setIncomeTransferAmount(BigDecimal incomeTransferAmount) {
        this.incomeTransferAmount = incomeTransferAmount;
    }

    public BigDecimal getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(BigDecimal totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    public String getTransferAccountNumber() {
        return transferAccountNumber;
    }

    public void setTransferAccountNumber(String transferAccountNumber) {
        this.transferAccountNumber = transferAccountNumber;
    }

    public String getMobileReturnVisit() {
        return mobileReturnVisit;
    }

    public void setMobileReturnVisit(String mobileReturnVisit) {
        this.mobileReturnVisit = mobileReturnVisit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public String getSellReason() {
        return sellReason;
    }

    public void setSellReason(String sellReason) {
        this.sellReason = sellReason;
    }

    public String getRefundNameChannelNo() {
        return refundNameChannelNo;
    }

    public void setRefundNameChannelNo(String refundNameChannelNo) {
        this.refundNameChannelNo = refundNameChannelNo;
    }

    public String getApplySellTime() {
        return applySellTime;
    }

    public void setApplySellTime(String applySellTime) {
        this.applySellTime = applySellTime;
    }
}
