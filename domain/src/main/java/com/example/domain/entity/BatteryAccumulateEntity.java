package com.example.domain.entity;



import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 电池累计表，电池入库时从电池表提取数据并插入
 * </p>
 *
 * @author Li GQ
 * @since 2018-06-26
 */
@Data
public class BatteryAccumulateEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 电池编号
     */
    @ExcelProperty(value = "电池编号" ,index = 0)
    private String batteryNo;
    /**
     * 从上次换电后该电池产生订单数
     */
    @ExcelProperty(value = "从上次换电后该电池产生订单数" ,index = 1)
    private Integer lastOrdersCount;
    /**
     * 上次换电后该电池行驶的里程,单位 米
     */
    @ExcelProperty(value = "上次换电后该电池行驶的里程,单位米" ,index = 2)
    private Long lastMileage;

    @ExcelProperty(value = "换电时间" ,index = 3)
    private Date createTime;
    /**
     * 电池换电一次产生的订单应收金额
     */
    @ExcelProperty(value = "电池换电一次产生的订单应收金额" ,index = 4)
    private BigDecimal totalAmount;
    /**
     * 电池换电一次产生的订单实收金额
     */
    @ExcelProperty(value = "电池换电一次产生的订单实收金额" ,index = 5)
    private BigDecimal totalOrderAmount;

    @ExcelProperty(value = "车辆Id" ,index = 6)
    private Long bikeId;
    @ExcelProperty(value = "车牌号" ,index = 7)
    private String plateNo;
    @ExcelProperty(value = "本次换电开始时间" ,index = 8)
    private Date startTime;
    @ExcelProperty(value = "本次下次换电开始时间" ,index = 9)
    private Date endTime;

}
