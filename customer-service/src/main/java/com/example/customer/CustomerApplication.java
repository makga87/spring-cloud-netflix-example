package com.example.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class CustomerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(CustomerApplication.class);
    }
}
