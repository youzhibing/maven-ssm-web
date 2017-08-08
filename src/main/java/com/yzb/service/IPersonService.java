package com.yzb.service;

import java.util.List;

import com.yzb.model.Person;
import com.yzb.util.DataSource;

public interface IPersonService {

	/**
	 * 加载全部的person
	 * @return
	 */
	List<Person> listAllPerson();
	
	/**
	 * 查询某个人的信息
	 * @param personId
	 * @return
	 */
	@DataSource("slave")			// 指定使用从数据源
	Person getPerson(int personId);
	
	boolean updatePerson(Person person);
}
