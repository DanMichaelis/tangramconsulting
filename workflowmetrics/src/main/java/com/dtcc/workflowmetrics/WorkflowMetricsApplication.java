package com.dtcc.workflowmetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
public class WorkflowMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowMetricsApplication.class, args);
	}
}
