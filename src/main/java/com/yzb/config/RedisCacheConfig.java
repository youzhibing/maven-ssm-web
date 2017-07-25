package com.yzb.config;

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
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

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
		// redisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer<Object>(Object.class));
		redisTemplate.setValueSerializer(new RedisSerializer<Object>()
		{

			@Override
			public byte[] serialize(Object t) throws SerializationException
			{
				if (t == null)
				{
					return new byte[0];
				}
				return JSON.toJSONString(t, SerializerFeature.WriteClassName)
						.getBytes();
			}

			@Override
			public Object deserialize(byte[] bytes)
					throws SerializationException
			{
				if (bytes == null || bytes.length <= 0)
				{
					return null;
				}
				String str = new String(bytes);

				return (Object) JSON.parseObject(str, Object.class);
			}

		});
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate)
	{

		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(expireTime); // Sets the default
														// expire time (in
														// seconds)
		return cacheManager;
	}
}
