package com.qxSpringCloud.controller;

import com.qxSpringCloud.entity.Dept;
import com.qxSpringCloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptClientService deptClientService;

    @GetMapping("/queryList")
    public Object queryList() {
        return deptClientService.queryList();
    }

    @GetMapping("/query/{id}")
    public Dept query(@PathVariable("id") Integer id){
        return deptClientService.query(id);
    }
}
