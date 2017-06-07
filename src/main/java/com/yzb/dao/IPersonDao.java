package com.yzb.dao;

import java.util.List;

import com.yzb.model.Person;

public interface IPersonDao
{
	/**
	 * 插入一条记录
	 * 
	 * @param person
	 */
	int savePerson(Person person);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<Person> listAllPerson();

	/**
	 * 查询某个person
	 * 
	 * @param id
	 * @return
	 */
	Person getPerson(int id);

	/**
	 * 删除某个person
	 * 
	 * @param id
	 * @return
	 */
	int removePerson(int id);

	/**
	 * 统计某个名字的数量
	 * 
	 * @param name
	 * @return
	 */
	int nameCount(String name);
	
	/**
	 * 更新某个person
	 * @param person
	 * @return
	 */
	int updatePerson(Person person);
}
