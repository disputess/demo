package com.example.service.datasources;

/**
 * @ClassName : GetBean
 * @Description : 事务中切换数据源前，添加代理设置
 * @Author : zhangxingping
 * @Date: 2019-10-29 13:04
 */
public  class BeanClass {

    public static <T> T getThisClass(T t) {
        return (T)SpringUtil.getBean( t.getClass());
    }
}