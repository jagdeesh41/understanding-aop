package com.learning.aop.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements Employee {
    @Override
    public String getData()
    {
        return "employee Data fetched";
    }
}
