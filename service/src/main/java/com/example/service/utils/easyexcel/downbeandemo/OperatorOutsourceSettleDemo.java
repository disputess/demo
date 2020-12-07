package com.example.service.utils.easyexcel.downbeandemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OperatorOutsourceSettleDemo implements Serializable {

    @ExcelProperty({"结算单号"})
    private Long outsourceSettleId;
    @ExcelProperty({"结算企业名称"})
    private String companyName;
    @ExcelProperty({"结算日期"})
    private String settleDate;
    @ExcelProperty({"应结算金额"})
    private BigDecimal cumulativeSettleAmount;
    @ExcelProperty({"扣款金额"})
    private BigDecimal deductionAmount;
    @ExcelProperty({"实际结算金额"})
    private BigDecimal actualSettleAmount;
    @ExcelProperty({"创建人"})
    private String createUserName;
    /**
     *   结算状态 1-待合规确认 2- 待财务付款 3-已结算 4-驳回
     */
    @ExcelProperty({"审核状态"})
    private String settleStatus;
    /**
     *   创建时间
     */
    @ExcelProperty({"创建时间"})
    private String createTime;



}
