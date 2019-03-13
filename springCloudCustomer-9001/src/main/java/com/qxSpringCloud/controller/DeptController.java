package com.qxSpringCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/dept")
public class DeptController {
    private static final String PROVIDER = "http://springCloudProvide/";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/queryList")
    public Object queryList() {
        return restTemplate.getForObject(PROVIDER + "dept/queryList", Object.class);
    }
}
