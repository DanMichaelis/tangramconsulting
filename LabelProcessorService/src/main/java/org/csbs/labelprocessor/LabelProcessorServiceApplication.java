package org.csbs.labelprocessor;

import org.csbs.labelprocessor.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class LabelProcessorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabelProcessorServiceApplication.class, args);
	}

}
