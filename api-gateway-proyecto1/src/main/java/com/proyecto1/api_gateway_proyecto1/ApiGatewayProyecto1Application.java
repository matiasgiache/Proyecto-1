package com.proyecto1.api_gateway_proyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayProyecto1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayProyecto1Application.class, args);
	}

}
