package com.qxSpringCloud.entity;

import lombok.Data;

import javax.persistence.*;
@Data
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;

    private String name;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "db_name")
    private String dbName;
}