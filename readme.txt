ssm：基本操作，持续更新，不定期的新增功能

spring 注入：
	检测@Value注入问题最好先排查下bean是否被多次扫描，实例化了多次。然后在@PostConstruct中打印出@Value常量。
	我遇到的情况是ContextLoaderListener和DispatcherServlet都扫描并实例化了@Controller注解类，但是DispatcherServlet实例化的类@Value注入常量失败，
	ContextLoaderListener实例化的类@Value注入常量成功，但是ContextLoaderListener实例化早，被覆盖掉了。最终导致实例化的@Controller类是没有注入常量的。

spring事务的隔离级别与传播行为
	参考：http://www.cnblogs.com/fjdingsd/p/5273008.html
		https://yq.aliyun.com/articles/48893

增加redis做缓存
	http://blog.csdn.net/defonds/article/details/48716161/
	spring 4.1以及之后的版本才有CachingConfigurerSupport