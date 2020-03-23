package com.example.hura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class HuraPlatformApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(HuraPlatformApplication.class);
    }
}
