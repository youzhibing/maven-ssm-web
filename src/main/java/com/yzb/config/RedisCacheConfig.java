package com.yzb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport
{
	@Value("${redis.host}")
	private String hostName;
	
	@Value("${redis.password}")
	private String password;
	
	@Value("${redis.port}")
	private int port;
	
	@Value("${redis.expireTime}")
	private int expireTime;

	@PostConstruct
	public void init()
	{
		System.out.println("RedisCacheConfig init");
		System.out.println(hostName + " " + port + " " + password + " " + expireTime);
	}
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory()
	{
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

		// Defaults
		redisConnectionFactory.setHostName(hostName);
		redisConnectionFactory.setPort(port);
		redisConnectionFactory.setPassword(password);
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf)
	{
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(cf);
		redisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer<Object>(Object.class));
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate)
	{
		
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(expireTime); // Sets the default expire time (in seconds)
		return cacheManager;
	}
}
