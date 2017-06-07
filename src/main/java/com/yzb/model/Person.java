package com.yzb.model;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * person 实体
 * 
 * @author Administrator
 *
 */
public class Person
{
	private int id;
	private String name;
	private int age;

	private Address homeAddress;
	
	private List<Book> books;
	
	public Person()
	{
	}

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	public Address getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	public List<Book> getBooks()
	{
		return books;
	}

	public void setBooks(List<Book> books)
	{
		this.books = books;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this, true);
	}
}
