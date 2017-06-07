package com.yzb.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzb.dao.IPersonDao;
import com.yzb.model.Person;

public class PersonDaoTest
{
	private static IPersonDao personDao;
	
	@BeforeClass
	public static void initPersonDao() throws Exception
	{
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "spring.xml", "mybatis-spring.xml",
						"mybatis-config.xml" });
		personDao = (IPersonDao) ac.getBean("IPersonDao");
	}

	/*@Test
	public void testRemovePerson()
	{
		int resultCount = personDao.removePerson(3);
		assertEquals(1, resultCount);
	}*/
	
	/*@Test
	public void testSavePerson()
	{
		Person p = new Person("老六", 22);
		int result = personDao.savePerson(p);
		assertEquals(1, result);
	}*/

	@Test
	public void testNameCount()
	{
		int count = personDao.nameCount("李小龙");
		assertEquals(1, count);
	}

}
