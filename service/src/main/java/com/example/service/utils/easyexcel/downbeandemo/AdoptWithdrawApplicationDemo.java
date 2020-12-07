package com.example.service.utils.easyexcel.downbeandemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdoptWithdrawApplicationDemo implements Serializable {
    @ExcelProperty({"用户手机号"})
    private String phoneNum;
    @ExcelProperty({"用户姓名"})
    private String realName;
    @ExcelProperty({"城市"})
    private String adCode;
    @ExcelProperty({"申请提现时间"})
    private String createTime;
    @ExcelProperty({"申请提现金额"})
    private String amount;
    @ExcelProperty({"提现状态"})
    private String withdrawStatus;
    @ExcelProperty({"提现来源"})
    private String withdrawTypeStr;
    @ExcelProperty({"提现支付宝账号"})
    private String alipayAccount;
    @ExcelProperty({"支付宝认证姓名"})
    private String userName;
    @ExcelProperty({"审核金额"})
    private String checkAmount;
    @ExcelProperty({"审核时间"})
    private String auditingTime;
    @ExcelProperty({"驳回备注"})
    private String remarks;

}
