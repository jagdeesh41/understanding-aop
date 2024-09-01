package com.learning.aop.controller;

import com.learning.aop.model.FoodDto;
import com.learning.aop.model.Pizza;
import com.learning.aop.service.EmployeeService;
import com.learning.aop.service.JunkService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class EmployeeController {
    EmployeeService employeeService;
    JunkService junkService;
    public EmployeeController(EmployeeService employeeService,JunkService junkService) {
        this.employeeService = employeeService;
        this.junkService = junkService;
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

    @GetMapping("/junk/pizza")
    public List<Pizza> getPizzaList()
    {
        return junkService.getTypesOfPizza();
    }

    @GetMapping("/junk/pizza/cost")
    public int totalPrice(@RequestBody FoodDto food)
    {
        log.info("Food Data {}",food);
        return junkService.calcPrice(food);
    }




}
