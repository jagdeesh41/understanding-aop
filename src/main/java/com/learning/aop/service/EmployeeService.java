package com.learning.aop.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public String getData()
    {
        return "employee Data fetched";
    }
}
