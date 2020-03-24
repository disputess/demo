package com.example.web.aspect;

import com.example.domain.entity.SysOperatorLogEntity;
import com.example.web.annotation.SysOperatorLog;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.apache.commons.lang.ArrayUtils;
/*import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;*/
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	/**
	 *自定义日志
	 */
	private Logger logger = LoggerFactory.getLogger(SysOperatorLogAspect.class);
	@Pointcut("@annotation(com.example.web.annotation.SysOperatorLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//请求的方法名
		Object[] args = point.getArgs();
		/**
		 * Signature 包含了方法名、申明类型以及地址等信息
		 */
		String class_name = point.getTarget().getClass().getName();
		String method_name = point.getSignature().getName();
		//重新定义日志
		logger = LoggerFactory.getLogger(point.getTarget().getClass());
		logger.info("class_name = {}",class_name);
		logger.info("method_name = {}",method_name);

		/**
		 * 获取方法的参数值数组。
		 */
		Object[] method_args = point.getArgs();

		try {
			/**
			 * 获取方法参数名称
			 */
			String[] paramNames = getFieldsName(class_name, method_name);

			/**
			 * 打印方法的参数名和参数值
			 */
			logParam(paramNames,method_args);
		} catch (Exception e) {
			//e.printStackTrace();
			//ignore
		}
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
	/**
	 * 使用javassist来获取方法参数名称
	 * @param class_name    类名
	 * @param method_name   方法名
	 * @return
	 * @throws Exception
	 */
	private String[] getFieldsName(String class_name, String method_name) throws Exception {
		Class<?> clazz = Class.forName(class_name);
		String clazz_name = clazz.getName();
		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(clazz);
		pool.insertClassPath(classPath);

		CtClass ctClass = pool.get(clazz_name);
		CtMethod ctMethod = ctClass.getDeclaredMethod(method_name);
		MethodInfo methodInfo = ctMethod.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		if(attr == null){
			return null;
		}
		String[] paramsArgsName = new String[ctMethod.getParameterTypes().length];
		int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
		for (int i=0;i<paramsArgsName.length;i++){
			paramsArgsName[i] = attr.variableName(i + pos);
		}
		return paramsArgsName;
	}


	/**
	 * 判断是否为基本类型：包括String
	 * @param clazz clazz
	 * @return  true：是;     false：不是
	 */
	private boolean isPrimite(Class<?> clazz){
		if (clazz.isPrimitive() || clazz == String.class){
			return true;
		}else {
			return false;
		}
	}


	/**
	 * 打印方法参数值  基本类型直接打印，非基本类型需要重写toString方法
	 * @param paramsArgsName    方法参数名数组
	 * @param paramsArgsValue   方法参数值数组
	 */
	private void logParam(String[] paramsArgsName,Object[] paramsArgsValue){
		if(ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)){
			logger.info("该方法没有参数");
			return;
		}
		StringBuffer buffer = new StringBuffer();
		//int currentUid=RequestContextHolder.get().getUid();
		for (int i=0;i<paramsArgsName.length;i++){
			//参数名
			String name = paramsArgsName[i];
			//参数值
			Object value = paramsArgsValue[i];
			buffer.append(name +" = ");
			if(value == null){
				buffer.append(value + "  ,");
			}else{
				if(isPrimite(value.getClass())){
					buffer.append(value + "  ,");
				}else {
					buffer.append(value.toString() + "  ,");
				}
			}

		}
		logger.info("输出注解上的参数值和对应的value"+buffer.toString()+"");
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
