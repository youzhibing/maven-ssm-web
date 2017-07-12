package com.yzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yzb.dao.IPersonDao;
import com.yzb.model.Person;
import com.yzb.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService
{

	@Autowired
	private IPersonDao personDao;

	@Override
	@Cacheable(cacheNames = {"allPersons"})
	public List<Person> listAllPerson()
	{
		System.out.println("service 调用了dao层");
		return personDao.listAllPerson();
	}

	@Override
	@Transactional(timeout=1000, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)		// 设置事务超时时间、隔离级别、传播行为
	public boolean updatePerson(Person person)
	{
		return false;
	}

	@Override
	public Person getPerson(int personId)
	{
		return personDao.getPerson(personId);
	}
	
}
