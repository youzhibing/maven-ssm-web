package com.yzb.service;

import java.util.List;

import com.yzb.model.Person;

public interface IPersonService {

	/**
	 * 加载全部的person
	 * @return
	 */
	List<Person> loadPersons();
}
