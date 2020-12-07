package com.example.web.enums;

import com.alibaba.fastjson.JSONObject;

public enum TaskTypeEnum {
    CHARING(1,"换电"),
    BACK_WAREHOUSE(2,"回库"),
    MAINTAIN(3,"检修"),
    DISPATCH(4,"调度"),
    LOOKFOR_BIKE(5,"寻车"),
    SPECIALOFFLINE (6,"特殊下架"),
    IMPOUND (7,"被扣押"),
    LONG_RENT_BIKE (8,"专享车辆"),
    REPAIR(9,"维修"),
    ILLEGAL(10,"违停挪车"),;

    TaskTypeEnum(Integer code, String desc) {
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

    public static TaskTypeEnum getEnum(Integer code){
        for(TaskTypeEnum scene : TaskTypeEnum.values()){
            if (scene.getCode() == code.intValue()){
                return scene;
            }
        }
        return null;
    }
    public static JSONObject getListTaskTypeEnum(){
        JSONObject map = new JSONObject();
        for (TaskTypeEnum typeEnum : TaskTypeEnum.values()) {
            map.put(typeEnum.code.toString(),typeEnum.desc);
        }
        return map;
    }
}
