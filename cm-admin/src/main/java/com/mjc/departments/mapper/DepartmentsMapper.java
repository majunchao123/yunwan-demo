package com.mjc.departments.mapper;

import com.mjc.departments.model.Departments;

public interface DepartmentsMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(Departments record);

    int insertSelective(Departments record);

    Departments selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);
}