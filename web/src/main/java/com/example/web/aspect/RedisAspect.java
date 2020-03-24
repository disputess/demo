package com.example.web.aspect;

/*import com.baojia.bike.operation.common.exception.BJException;*/
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Redis切面处理类
 *
 * @author xukaisheng
 * @email 18511430131@163.com
 * @date 2017-07-17 23:30
 */
@Aspect
@Configuration
public class RedisAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
/*
    @Around("execution(* com.baojia.bike.operation.service.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Exception e) {
            logger.error("redis error", e);
            throw new BJException("Redis服务异常");
        }
        return result;
    }*/
}
