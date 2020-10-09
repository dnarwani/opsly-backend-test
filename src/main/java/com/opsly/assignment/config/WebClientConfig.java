package com.opsly.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Value("${opsly.url}")
	private String url;
	
	@Bean
	public WebClient createWebClient() {
		return WebClient.create(url);
	}

}
