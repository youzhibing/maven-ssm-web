package com.yzb.test;

import javax.mail.MessagingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzb.util.mail.JavaMailClient;


public class MailTest
{
	private JavaMailClient mailClient = null;
	
	@Before
	public void init()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring.xml"});
		mailClient = (JavaMailClient)ac.getBean("mailClient");
	}
	
	@Test
	public void isNull()
	{
		System.out.println(mailClient == null);
	}
	
	@Test
	public void sendMail() throws MessagingException
	{
		mailClient.sendSimpleMail("920168254@qq.com", "test", "hello world!");
	}
}
