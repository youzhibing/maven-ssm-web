package com.yzb.dao;

import java.util.List;

import com.yzb.model.Person;

public interface IPersonDao {
	/**
	 * 插入一条记录
	 * @param person
	 */
	void insert(Person person);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Person> queryAll();
}
