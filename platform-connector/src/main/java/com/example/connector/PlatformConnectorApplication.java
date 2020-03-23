package com.example.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class PlatformConnectorApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(PlatformConnectorApplication.class);
    }
}
