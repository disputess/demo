package com.example.web.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 * @author xukaisheng
 * @email 18511430131@163.com
 * @date 2017/9/23 14:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
