package com.ly.client.config;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;

import java.util.Properties;

/**
 * Created by lany on 2019/6/27.
 */
@Configuration
public class GemfireConfiguration {

	private static final String SECURITY_CLIENT = "security-client-auth-init";
	private static final String SECURITY_USERNAME = "security-username";
	private static final String SECURITY_PASSWORD = "security-password";

//    @Bean
//    Properties gemfireProperties(@Value("${gemfire.log.level:config}") String logLevel,
//                                 @Value("${application.name:GemFireClientDemo") String applicationName,
//                                 @Value("${gemfire.username}") String username, @Value("${gemfire.password}") String password) {
//
//		Properties gemfireProperties = new Properties();
//
//		gemfireProperties.setProperty("name", applicationName);
//		gemfireProperties.setProperty("log-level", logLevel);
//		gemfireProperties.setProperty(SECURITY_CLIENT,
//				"com.tmo.gemfire.security.UserAuthInitialize.create");
//		gemfireProperties.setProperty(SECURITY_USERNAME, username);
//		gemfireProperties.setProperty(SECURITY_PASSWORD, password);
//
//		return gemfireProperties;
//	}
//
//    public ClientCacheFactoryBean clientCacheFactoryBean(){
//        return new ClientCacheFactoryBean()
//                .setProperties();
//    }

//	@Bean
//	public ClientCache getClientCache(){
//		return new ClientCacheFactory()
//				.set("security-client-authinit", "com.ly.client.security.UserPasswordAuthInit.create")
//				.set("security-username","admin")
//				.set("security-password","passw0rd")
//				.set("cache-xml-file","config/cache-client.xml")
////            .set("gemfire.properties","gemfire.properties")
//				.create();
//	}

}
