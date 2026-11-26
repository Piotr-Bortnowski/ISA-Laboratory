package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("race-cars", r -> r
						.path("/api/race-cars/**")
						.uri("lb://race-car-app")
				)
				.route("race-cars-race-cars", r -> r
						.path("/api/racing-classes/*/race-cars/**")
						.uri("lb://race-car-app")
				)
				.route("racing-classes", r -> r
						.path("/api/racing-classes/**")
						.uri("lb://racing-class-app")
				)
				.build();
	}
}
