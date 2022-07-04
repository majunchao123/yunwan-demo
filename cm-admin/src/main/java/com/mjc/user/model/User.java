package com.mjc.user.model;

import com.mjc.departments.model.Departments;
import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

    private Integer employeeId;

    private Departments departments;
    
}