package com.example.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class StatusApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(StatusApplication.class);
    }
}
