package com.example.web.enums;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: amber
 * Date: 2018-06-13
 * Time: 15:25
 */
public class BikeStateEnum extends EnumType {

    protected BikeStateEnum(int type, String name) {
        super(type, name);
    }

    /**
     * '10-工厂检验中 20-运输中 30-库管中 40-待出租 50-已预约 60-出租中 70-特殊下架 80-被扣押 90-已丢失',
     * 100-维修中 110-馈电停租 130-已报废 140-换电中 150-调度中 160-待回库 170-回库中 175-待确认回库 180-待检修 190-检修中 195-待寻车 200-寻车中 210-越界停租
     */
    public static final BikeStateEnum FACTORY_OVERHAUL = new BikeStateEnum(10, "工厂检验中");
    public static final BikeStateEnum TRANSITING = new BikeStateEnum(20, "运输中");
    public static final BikeStateEnum REPERTORY = new BikeStateEnum(30, "库管中");
    public static final BikeStateEnum FREEZING = new BikeStateEnum(35, "冻结中");
    public static final BikeStateEnum UN_RENT = new BikeStateEnum(40, "待出租");
    public static final BikeStateEnum RESERVED = new BikeStateEnum(50, "已预约");
    public static final BikeStateEnum LEASE = new BikeStateEnum(60, "出租中");
    public static final BikeStateEnum LOWER_FRAME = new BikeStateEnum(70, "特殊下架");
    public static final BikeStateEnum IMPOUNDED = new BikeStateEnum(80, "被扣押");
    public static final BikeStateEnum LOSING = new BikeStateEnum(90, "已丢失");

    public static final BikeStateEnum REPAIR = new BikeStateEnum(100, "维修中");
    public static final BikeStateEnum FEED_STOP_RENT = new BikeStateEnum(110, "馈电停租");
    public static final BikeStateEnum SCRAP = new BikeStateEnum(130, "已报废");
    public static final BikeStateEnum SWITCHING = new BikeStateEnum(140, "换电中");
    public static final BikeStateEnum SCHEDULING = new BikeStateEnum(150, "调度中");
    public static final BikeStateEnum WAIT_STOREHOUSE = new BikeStateEnum(160, "待回库");
    public static final BikeStateEnum STOREHOUSE = new BikeStateEnum(170, "回库中");
    public static final BikeStateEnum CONFIRM_STORE = new BikeStateEnum(175, "待确认回库");
    public static final BikeStateEnum WAIT_OVERHAUL = new BikeStateEnum(180, "待检修");
    public static final BikeStateEnum OVERHAUL = new BikeStateEnum(190, "检修中");
    public static final BikeStateEnum WAIT_CAR_SEARCH = new BikeStateEnum(195, "待寻车");
    public static final BikeStateEnum CAR_SEARCH = new BikeStateEnum(200, "寻车中");
    public static final BikeStateEnum OVERSTEP_STOP_RENT = new BikeStateEnum(210, "越界停租");
    public static final BikeStateEnum SOLD = new BikeStateEnum(220, "已售卖");



    private static final Map<Integer, String> enumMap = new ConcurrentHashMap<>();


    static{
        enumMap.put(BikeStateEnum.FACTORY_OVERHAUL.getType(), BikeStateEnum.FACTORY_OVERHAUL.getName());
        enumMap.put(BikeStateEnum.TRANSITING.getType(), BikeStateEnum.TRANSITING.getName());
        enumMap.put(BikeStateEnum.REPERTORY.getType(), BikeStateEnum.REPERTORY.getName());
        enumMap.put(BikeStateEnum.FREEZING.getType(), BikeStateEnum.FREEZING.getName());
        enumMap.put(BikeStateEnum.UN_RENT.getType(), BikeStateEnum.UN_RENT.getName());
        enumMap.put(BikeStateEnum.RESERVED.getType(), BikeStateEnum.RESERVED.getName());
        enumMap.put(BikeStateEnum.LEASE.getType(), BikeStateEnum.LEASE.getName());
        enumMap.put(BikeStateEnum.LOWER_FRAME.getType(), BikeStateEnum.LOWER_FRAME.getName());
        enumMap.put(BikeStateEnum.IMPOUNDED.getType(), BikeStateEnum.IMPOUNDED.getName());
        enumMap.put(BikeStateEnum.LOSING.getType(), BikeStateEnum.LOSING.getName());

        enumMap.put(BikeStateEnum.REPAIR.getType(), BikeStateEnum.REPAIR.getName());
        enumMap.put(BikeStateEnum.FEED_STOP_RENT.getType(), BikeStateEnum.FEED_STOP_RENT.getName());
        enumMap.put(BikeStateEnum.SCRAP.getType(), BikeStateEnum.SCRAP.getName());
        enumMap.put(BikeStateEnum.SWITCHING.getType(), BikeStateEnum.SWITCHING.getName());
        enumMap.put(BikeStateEnum.SCHEDULING.getType(), BikeStateEnum.SCHEDULING.getName());
        enumMap.put(BikeStateEnum.WAIT_STOREHOUSE.getType(), BikeStateEnum.WAIT_STOREHOUSE.getName());
        enumMap.put(BikeStateEnum.STOREHOUSE.getType(), BikeStateEnum.STOREHOUSE.getName());
        enumMap.put(BikeStateEnum.WAIT_OVERHAUL.getType(), BikeStateEnum.WAIT_OVERHAUL.getName());

        enumMap.put(BikeStateEnum.OVERHAUL.getType(), BikeStateEnum.OVERHAUL.getName());
        enumMap.put(BikeStateEnum.CAR_SEARCH.getType(), BikeStateEnum.CAR_SEARCH.getName());
        enumMap.put(BikeStateEnum.OVERSTEP_STOP_RENT.getType(), BikeStateEnum.OVERSTEP_STOP_RENT.getName());

        enumMap.put(BikeStateEnum.CONFIRM_STORE.getType(), BikeStateEnum.CONFIRM_STORE.getName());
        enumMap.put(BikeStateEnum.WAIT_CAR_SEARCH.getType(), BikeStateEnum.WAIT_CAR_SEARCH.getName());
        enumMap.put(BikeStateEnum.SOLD.getType(), BikeStateEnum.SOLD.getName());
    }

    public static Map<Integer, String> getEnumMap(){
        return enumMap;
    }
}
