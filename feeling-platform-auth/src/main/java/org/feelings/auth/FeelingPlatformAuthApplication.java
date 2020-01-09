package org.feelings.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyq
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FeelingPlatformAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeelingPlatformAuthApplication.class, args);
	}

}
