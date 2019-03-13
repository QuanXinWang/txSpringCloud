package com.qxSpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
@EnableDiscoveryClient
public class springCloudConsumerHystrixDashboard {


    public static void main(String[] args) {
        SpringApplication.run(springCloudConsumerHystrixDashboard.class,args);
    }

}
