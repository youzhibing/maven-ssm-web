package com.huawei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.dao.IPersonDao;
import com.huawei.model.Person;
import com.huawei.service.IPersonService;

@Service("personService")
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDao personDao;

	@Override
	public List<Person> loadPersons() {
		return personDao.queryAll();
	}
	
}
