package com.qxSpringCloud.service;

import com.qxSpringCloud.entity.Dept;

import java.util.List;

public interface DeptService {
    int add(Dept dept);

    List<Dept> queryList();

    Dept query(Integer id);

    int updateDept(Dept dept);

    int delDept(Integer id);
}
