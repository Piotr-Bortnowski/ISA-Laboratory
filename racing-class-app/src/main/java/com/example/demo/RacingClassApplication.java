package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class RacingClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacingClassApplication.class, args);
	}

	/**
	 * Plain builder used by everything else in the context, including the Eureka client itself.
	 * Without it the Eureka client would pick up the load-balanced builder below and try to resolve
	 * "discovery" (the Eureka server host) as a service name, so registration would fail.
	 */
	@Bean
	@Primary
	RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

	/**
	 * Load-balanced builder: host in URL is treated as a service name from Eureka.
	 * Injected only where explicitly requested with @LoadBalanced.
	 */
	@Bean
	@LoadBalanced
	RestClient.Builder loadBalancedRestClientBuilder() {
		return RestClient.builder();
	}

}
