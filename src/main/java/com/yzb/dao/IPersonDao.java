package com.yzb.dao;

import java.util.List;

import com.yzb.model.Person;

public interface IPersonDao {
	/**
	 * 插入一条记录
	 * @param person
	 */
	void savePerson(Person person);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Person> listAllPerson();
	
	/**
	 * 查询某个person
	 * @param id
	 * @return
	 */
	Person getPerson(int id);
}
