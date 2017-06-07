package com.yzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Person> listAllPerson()
	{
		return personDao.listAllPerson();
	}

	@Override
	@Transactional(timeout=1000, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)		// 设置事务超时时间、隔离级别、传播行为
	public boolean updatePerson(Person person)
	{
		return false;
	}

	
}
