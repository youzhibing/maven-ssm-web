package com.yzb.util;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class DataSourceAspect
{
	/**
	 * 在dao层方法获取datasource对象之前，在切面中指定当前线程数据源
	 */
	public void before(JoinPoint point)
	{

		Object target = point.getTarget();
		String method = point.getSignature().getName();
		Class<?>[] classz = target.getClass().getInterfaces();						// 获取目标类的接口， 所以@DataSource需要写在接口上
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
				.getMethod().getParameterTypes();
		try
		{
			Method m = classz[0].getMethod(method, parameterTypes);
			if (m != null && m.isAnnotationPresent(DataSource.class))
			{
				DataSource data = m.getAnnotation(DataSource.class);
				System.out.println("用户选择数据库库类型：" + data.value());
				HandleDataSource.putDataSource(data.value());						// 数据源放到当前线程中
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	}
