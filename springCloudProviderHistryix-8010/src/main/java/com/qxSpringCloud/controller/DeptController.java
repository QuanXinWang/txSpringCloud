package com.qxSpringCloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qxSpringCloud.entity.Dept;
import com.qxSpringCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/queryList")
    public List<Dept> queryList(){
        return deptService.queryList();
    }

    @GetMapping("/query/{id}")
    // 使用熔断
//    @HystrixCommand(fallbackMethod = "dept")
    public Dept query(@PathVariable("id") Integer id){
        final Dept query = deptService.query(id);
        if (query == null){
            throw new RuntimeException("null");
        }
        return deptService.query(id);
    }

    /**
     * 熔断 当访问出错时候给一个合适的响应
     * @param id
     * @return
     */
//    public Dept dept(@PathVariable("id") Integer id){
//        Dept dept = new Dept();
//        dept.setId(id);
//        dept.setName("当前使用id：" + id + ";无此数据。");
//        return dept;
//    }
}
