package com.example.optical_network_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Entry point for spring boot application
 */

@SpringBootApplication // Tells Spring to auto-configure and scan THIS package for controllers, database models, sercvices, etc.
public class OpticalNetworkManagerApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(OpticalNetworkManagerApplication.class, args); // Starts Tomcat server on port 8080 by default
	}

}
