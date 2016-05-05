/**
 * 
 */
package com.ziroom.mytesla.system.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;



/**
 * 通过切面动态配置数据源
 * @author liuys
 * 2015年8月11日
 */
public class DataSourceAspect {
	
	public void before(JoinPoint point)
    {
		//logger.info("--111--"+point.toString());
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        Signature sign=point.getSignature();
        MethodSignature msgin=(MethodSignature) sign;
        Class<?>[] parameterTypes = msgin.getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
            	DataSource data = m
                        .getAnnotation(DataSource.class);
                DynamicDataSourceHolder.putDataSource(data.value());
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
