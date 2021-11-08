package com.example.domain.enums;

/**
 * @author Li GQ 2018/6/19
 * <p>
 * 规则：
 * 小于1000时，最高一位表示父任务类型；例如 18小时无单47，最高位为4 表示调度任务
 * 大于1000时，最高两位表示父任务类型；例如 1001，最高位为10 未来会表示新的任务
 */
public enum TaskSubTypeEnum {
    //
    LOWPOWER(10, "低电", "低于45%大于等于35%的在线车辆"),
    SHOTOFPOWER(11, "缺电", "低于35%大于等于25%的在线车辆"),
    LACKPOWER(12, "馈电", "低于25%大于0的在线车辆"),
    NOPOWER(13, "无电", "电量为0且在线或离线的车"),
    HAVE_TROUBLE_GO_HOME(20, "存在故障需回库", "被标记为待回库的车辆"),
    FOUND_GO_HOME(21, "已寻回需回库", "被标记寻车完成的车辆"),
    USER_TROUBLE_GO_HOME(22, "用户上报故障", "最近30天内有3个不不同用户上报拧巴不走和线路损坏故障的车辆(上架后清除故障标记)"),
    INVALID_ORDERS_3_TO_7_TIMES(23, "3-7次无效订单", "连续3到7次订单里程低于100米且使用时间低于3分钟且电量大于40%的车辆"),
    INVALID_ORDERS_8_TIMES(24, "8次及以上无效订单", "连续8次及以上订单里程低于100米且使用时间低于3分钟的车辆"),
    NO_ORDER_IN_10DAYS(25, "10日以上无单", "最新上架时间距离上次订单已经超过240小时没有订单的车辆。（预约车辆不不算做订单）"),

    //该任务子类型已经去掉
    HAVE_ORDER_NO_METER(30, "有单无程", "三次正常支付的订单总里程小于200米（正常完成一次任务后，清除“有单无程”的属性）"),
    USER_REPORT(31, "用户上报", "最近30天内有3个不不同用户上报同一个故障的车辆（正常完成⼀一次任务后，如果没有地勤上报故障清除“用户上报”的属性）"),
    HAVE_POWER_BUT_OFFLINE(32, "有电离线", "电量量不不为0且离线的车，且维持1小时“有电离线”状态。"),
    BOX_TROUBLE(33, "疑似GPS故障",
            "在线无星：车辆盒子在线有心跳,无定位无星;" +
                    "其中:" +
                    "*无定位无星的判断是25分钟内未收到状态包;" +
                    "*离线无心的判断是20分钟内未收到心跳包;" +
                    "*有定位有星:" +
                    "   不馈电时：状态包，静态10分钟一次，动态5秒钟一次。" +
                    "   馈电时：在线有心：心跳包，3分钟一次" +
                    "非稳盒子：最近24小时内盒子心跳停止超过10次的车辆（每30分钟查⼀一次“24小时内盒子登陆超过10次”的车辆）" +
                    "无效盒子：在线，但从未上报过定位（每30分钟查一次）"),
    OUT_RANGE(40, "越界", "超出运营区域的车辆"),
    NO_ORDER_IN_2DAYS(41, "2-5日无单", "最新上架时间距离上次订单已经超过48小时但小于120小时没有订单的车辆。预约车辆不不算做订单"),
    NO_ORDER_IN_5DAYS(42, "5-10日无单", "最新上架时间距离上次订单已经超过120不超过240小时没有订单的车辆。（预约车辆不不算做订单）"),
    //该子类型已经去掉，但是为了已经派单的老数据的显示正常，所以暂时不去掉
    OUT_RETURN_RANGE(43, "还车区外", "还车区外需调度"),
    IN_FORBID_RUN(44, "禁行区内", "禁行区内需调度"),
    OUT_SERVICE_RANGE(45, "界内服务区外", "界内服务区外需调度"),
    IN_SERVICE_OUT_RETURN_RANGE(46, "服务区内还车区外", "超出还车区,但在服务区内"),
    NO_ORDER_IN_18HOUR(47, "18-24小时无单", "最新上架时间距离上次订单已经超过18小时但小于24小时没有订单的车辆。预约车辆不不算做订单"),
    NO_ORDER_3H_6H(481, "3-6小时无单", ""),
    NO_ORDER_6H_12H(482, "6-12小时无单", ""),
    NO_ORDER_12H_18H(484, "12-18小时无单", ""),
    NO_ORDER_24H_48H(485, "24-48小时无单", ""),
    OTHER_DISPATCHER(480, "其他", "其他类型调度任务"),

    LOOK_FOR_BIKE(50, "寻车", "被运维连续3次以上（不不包括3次）上报“未找到车”的车辆"),
    SPECIALOFFLINE_SUB(60, "特殊下架", ""),
    IMPOUND_SUB(70, "被扣押", ""),
    IURGENT_CHANG_BATTERY(80, "紧急换电", "发起紧急换电申请"),
    FREE_CHANG_BATTERY(81, "免费换电", "购买换电无忧套餐的车辆缺电且用户没有发起紧急换电的情况下生成"),
    NEW_BIKE_HOME(82, "新车上门", "购买新车然后将新车送到指定地址"),
    NEW_BATTERY_HOME(83, "电池上门", "购买电池后送到车辆的位置"),
    //改类型存在数据库里，只给运营后台使用，掌柜不显示
    BATTERY_SITE_CHANGE(84, "电站换电", "电站管理员自行换电"),
    BIKE_RECYCLE(85, "车辆回收", "订单到期后回收车辆"),
    VIP_BIKE_USER_TROUBLE(86, "专享检修", "专享车辆持有人上报车辆故障"),
    VIP_USER_LAUNCH_EMERGENCY_RESCUE(87, "紧急救援", "专享用户发起紧急救援"),
    VIP_BIKE_KEY_DOOR(88, "钥匙上门", "专享用户发起钥匙上门"),
    VIP_BIKE_PARTS_DOOR(89, "配件上门", "专享用户发起配件上门"),
    ILLEGAL_PARK(1000,"违停上报","");


    TaskSubTypeEnum(Integer code, String desc, String definition) {
        this.code = code;
        this.desc = desc;
        this.definition = definition;
    }

    private Integer code;
    private String desc;
    private String definition;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    public static TaskSubTypeEnum getEnum(Integer code) {
        for (TaskSubTypeEnum scene : TaskSubTypeEnum.values()) {
            if (scene.getCode().equals(code)) {
                return scene;
            }
        }
        return null;
    }

    private static int getHighestNum(int num){
        int val=num;
        int tmp;
        while((tmp=val/10)>0){
            val=tmp;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(1001/100);
    }
}
