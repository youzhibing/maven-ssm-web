package com.yzb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzb.dao.IPersonDao;

public class MybatisTest
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring.xml", "mybatis-spring.xml", "mybatis-config.xml"});
		IPersonDao personDao= (IPersonDao)ac.getBean("IPersonDao");
		//System.out.println(personDao.listAllPerson());
		System.out.println(personDao.getPerson(1));
	}
}
