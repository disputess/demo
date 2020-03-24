package com.example.web.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysOperatorLog {
	String value() default "";
    int operatorType() default 1;
}
