package com.fs.consultingagency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class ConsultingAgencyApplication {
	static Logger logger = LoggerFactory.getLogger(ConsultingAgencyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsultingAgencyApplication.class, args);
		logger.info("Consulting Agency Application Application Started!!!");
	}

	@Autowired
	public void setEnv(Environment environment)
	{
		System.out.println(environment.getProperty("url"));
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
