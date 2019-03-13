package com.qxSpringCloud.dao;

import com.qxSpringCloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}