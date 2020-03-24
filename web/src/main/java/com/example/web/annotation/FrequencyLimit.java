package com.example.web.annotation;

import java.lang.annotation.*;

/**
 * Created by wanchao on 2018/4/23.
 * ip 频率限制切面
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FrequencyLimit {
    String count();
    String second();
}
