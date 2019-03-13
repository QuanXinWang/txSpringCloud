package com.qxSpringCloud.controller;

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

    @GetMapping("/queryList/{id}")
    public Dept query(@PathVariable("id") Integer id){
        return deptService.query(id);
    }
}
