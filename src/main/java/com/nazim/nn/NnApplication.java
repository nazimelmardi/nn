package com.nazim.nn;

import com.nazim.nn.infrastructure.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageConfig.class})
public class NnApplication {

	public static void main(String[] args) {
		SpringApplication.run(NnApplication.class, args);
	}

}
