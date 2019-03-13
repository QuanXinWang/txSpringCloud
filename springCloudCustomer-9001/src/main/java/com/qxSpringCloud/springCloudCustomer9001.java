package com.qxSpringCloud;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
// 在启动该微服务时候使用自定义的Ribbon配置类，使其生效
// 自定义的Ribbon不能放在主启动类扫描的包下面，否则不生效
@RibbonClient(name = "springCloudProvide", configuration = MySelfRule.class)
public class springCloudCustomer9001 {
    public static void main(String[] args) {
        SpringApplication.run(springCloudCustomer9001.class, args);
    }
}
