package com.ly.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;

@SpringBootApplication
@ClientCacheApplication
@ImportResource("classpath:/config/cache-client.xml")
public class GemfireLyClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireLyClientApplication.class, args);
	}



}
