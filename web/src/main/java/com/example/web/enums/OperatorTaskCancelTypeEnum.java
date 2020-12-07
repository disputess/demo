package com.example.web.enums;

/**
 * @Auther: chi
 * @Date: 2018/6/12 14:46
 * @Description:
 */
public enum OperatorTaskCancelTypeEnum {

    NOT_FOUND(1,"未找到车"),
    BIKE_FAILURE(2,"车辆故障"),
    BIKE_DETAINED(3,"车辆被扣押"),
    ELSE (4,"其它"),
    BACKGROUND_CANCEL (5,"后台取消"),
    MANUALLY_CANCEL (6,"工单失效,运维手动取消"),
    AUTO_CANCEL (7,"工单失效,运维自动取消"),
    PERSONAL_TASK_CANCEL(8,"专享车取消任务"),
    CLOCK_OFF_ASSIGN_TASK_CANCEL(9,"强制下班取消");
    OperatorTaskCancelTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static OperatorTaskCancelTypeEnum getEnum(Integer code){
        for(OperatorTaskCancelTypeEnum scene : OperatorTaskCancelTypeEnum.values()){
            if (scene.getCode() == code.intValue()){
                return scene;
            }
        }
        return null;
    }
}
