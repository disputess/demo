package com.example.web.aspect;

import com.example.domain.entity.SysOperatorLogEntity;
import com.example.web.annotation.SysOperatorLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;


/**
 * 系统日志，切面处理类

 */
@Aspect
@Component
public class SysOperatorLogAspect {

	@Pointcut("@annotation(com.example.web.annotation.SysOperatorLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//请求的方法名
		Object[] args = point.getArgs();
		try{
			for( int i = 0;i<args.length;i++){
				System.out.println("注解获取的参数value"+args[i]);
			}
		}catch (Exception e){

		}
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;



		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysOperatorLogEntity sysLog = new SysOperatorLogEntity();
		SysOperatorLog syslog = method.getAnnotation(SysOperatorLog.class);
		if(syslog != null){
			//注解上的描述
			sysLog.setOperate(syslog.value());
		}
		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
           for( int i = 0;i<args.length;i++){
			   System.out.println(args[i]);
		   }
			//String params = new Gson().toJson(args[0]);
			//sysLog.setParams(params);
		}catch (Exception e){

		}

	}
}
