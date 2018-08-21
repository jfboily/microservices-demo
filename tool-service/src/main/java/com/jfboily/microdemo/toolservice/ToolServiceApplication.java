package com.jfboily.microdemo.toolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ToolServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolServiceApplication.class, args);
    }
}
