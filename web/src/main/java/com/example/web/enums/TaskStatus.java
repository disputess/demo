package com.example.web.enums;

public enum TaskStatus {
    PICK_UP_BIKE(1,"取车中"),
    DISTRIBUTION(2,"配送中"),
    COMPLETE(3,"配送完成");

    TaskStatus(Integer code, String desc) {
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

    public static TaskStatus getEnum(Integer code){
        for(TaskStatus scene : TaskStatus.values()){
            if (scene.getCode() == code.intValue()){
                return scene;
            }
        }
        return null;
    }
}
