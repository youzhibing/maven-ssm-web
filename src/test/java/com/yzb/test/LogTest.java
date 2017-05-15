package com.yzb.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args)
	{
		LOGGER.info("...info");
		LOGGER.warn("...warn");
	}
}
