package com.qxSpringCloud.service.impl;

import com.qxSpringCloud.dao.DeptMapper;
import com.qxSpringCloud.entity.Dept;
import com.qxSpringCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;


    @Override
    public int add(Dept dept) {
        return deptMapper.insertSelective(dept);
    }

    @Override
    public List<Dept> queryList() {
        return deptMapper.selectAll();
    }

    @Override
    public Dept query(Integer id) {
        Dept dept = new Dept();
        dept.setId(id);
        return deptMapper.selectOne(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateByPrimaryKeySelective(dept);
    }

    @Override
    public int delDept(Integer id) {
        Dept dept = new Dept();
        dept.setId(id);
        return deptMapper.updateByPrimaryKeySelective(dept);
    }
}
