package com.example.web.aspect;

/*import com.baojia.bike.operation.common.exception.BJException;
import com.baojia.bike.operation.common.utils.Constant;
import com.baojia.bike.operation.service.utils.RedisUtils;
import com.baojia.bike.operation.web.annotation.FrequencyLimit;
import com.baojia.bike.operation.web.utils.HttpContextUtils;
import com.baojia.bike.operation.web.utils.IPUtils;*/
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.data.redis.core.RedisTemplate;*/
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanchao on 2018/4/23.
 *  频率限制，不保证多线程精确性，但可以保证整体有效
 */
@Aspect
@Component
public class FrequencyLimitAspect {
    private static final Logger logger = LoggerFactory.getLogger(FrequencyLimitAspect.class);
   /* @Resource
    private RedisUtils redisUtils;
    @Resource
    private RedisTemplate redisTemplate;

*/
    /*@Before("@annotation(frequencyLimit)")
    public void limit( FrequencyLimit frequencyLimit) throws Throwable {
        String countStr = frequencyLimit.count();
        Integer count = Integer.valueOf(countStr);
        String secondStr = frequencyLimit.second();
        Long second = Long.valueOf(secondStr);
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String ip = IPUtils.getIpAddr(request);
        if (ip != null){
            Object blackObject =  redisUtils.get(Constant.FREQUENCYLIMITBLACKKEY + ip);
            if (blackObject != null){
                throw new BJException("该ip已被拉黑ip:"+ip );
            }
            String ipKey = Constant.FREQUENCYLIMITKEY + ip;
            Object object =  redisUtils.get(ipKey);
            if (object == null){
                redisUtils.set(ipKey,"1",second);
            }else {
                Long expire =   redisUtils.getExpire(ipKey);
                if (expire > second || expire == -1){
                    logger.error("过期时间出错ipKey：{}，expire:{}", ipKey, expire);
                    redisTemplate.expire(ipKey, second, TimeUnit.SECONDS);
                }
                redisTemplate.opsForValue().increment(ipKey, 1L);
                Integer ipCount = Integer.valueOf(object.toString());
                if (ipCount >= count) {
                    if (ipCount > 50){
                        redisTemplate.opsForValue().set(Constant.FREQUENCYLIMITBLACKKEY + ip, "1", 1, TimeUnit.DAYS);
                        logger.error("访问频繁ip：{},count:{},已拉黑", ip, ipCount);
                    }
                    logger.info("该ip已超过调用限制：{}",ip);
                    throw new BJException("访问频繁,请稍后再试" );
                }
            }
        }
    }*/
}
