package com.yzb.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Address implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String country;
	private String province;
	private String city;
	private String town;
	private String village;
	private String street;
	private int houseNumber;
	private int personId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getTown()
	{
		return town;
	}

	public void setTown(String town)
	{
		this.town = town;
	}

	public String getVillage()
	{
		return village;
	}

	public void setVillage(String village)
	{
		this.village = village;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public int getHouseNumber()
	{
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber)
	{
		this.houseNumber = houseNumber;
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
