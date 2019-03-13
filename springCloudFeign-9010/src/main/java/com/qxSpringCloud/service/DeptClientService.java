package com.qxSpringCloud.service;

import com.qxSpringCloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "springCloudProvide",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
    @GetMapping("/dept/queryList")
    List<Dept> queryList();

    @GetMapping("/dept/query/{id}")
    Dept query(@PathVariable("id") Integer id);

}
