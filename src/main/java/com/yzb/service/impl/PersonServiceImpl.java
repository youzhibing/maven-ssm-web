package com.yzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzb.dao.IPersonDao;
import com.yzb.model.Person;
import com.yzb.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDao personDao;

	@Override
	public List<Person> loadPersons() {
		return personDao.queryAll();
	}
	
}
