package com.learning.aop.controller;

import com.learning.aop.service.EmployeeService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class EmployeeController {
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/fetchEmployee")
    public String fetchEmployee()
    {
        log.info("EmployeeController.fetchEmployee()");
        return "item fetched";
    }
    @GetMapping(path = "/fetchEmployee/")
    public String fetchEmployeeWithId(@RequestParam("id") String id)
    {
        log.info("EmployeeController.fetchEmployee(String id)");
        return "item fetched";
    }
    @GetMapping(path = "/fetchEmployee/intId")
    public int fetchEmployeeWithId(@RequestParam("id") int id)
    {
        log.info("EmployeeController.fetchEmployee(String id)");
        return 2;
    }
    @GetMapping(path = "/fetchEmployee/multiple")
    public String fetchEmployeeWithMultipleParams(@RequestParam("id") int id, @RequestParam("user") String user)
    {
        log.info("EmployeeController.fetchEmployee(int id,String user)");
        return user+id;
    }
    @GetMapping("/data")
    public String fetchData()
    {
        log.info("EmployeeController.fetchData()");
        return employeeService.getData();
    }




}
