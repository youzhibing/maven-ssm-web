package com.yzb.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Book implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String price;
	private String publisher;
	private int personId;

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

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPublisher()
	{
		return publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public int getPersonId()
	{
		return personId;
	}

	public void setPersonId(int personId)
	{
		this.personId = personId;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this, true);
	}

}
