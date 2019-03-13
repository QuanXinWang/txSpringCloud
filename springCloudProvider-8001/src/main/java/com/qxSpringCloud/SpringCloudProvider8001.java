package com.qxSpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider8001.class,args);
    }
}
