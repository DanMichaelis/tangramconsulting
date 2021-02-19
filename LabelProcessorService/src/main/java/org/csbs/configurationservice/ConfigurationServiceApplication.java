package org.csbs.configurationservice;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.csbs.configurationservice.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableCircuitBreaker
@EnableAsync
@EnableDiscoveryClient
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ConfigurationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServiceApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
