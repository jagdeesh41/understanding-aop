package com.learning.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(public String com.learning.aop.controller.EmployeeController.fetchEmployee())")
    public void beforeMethod()
    {
        log.info("inside before  method Aspect");
    }
    @After("execution(public String com.learning.aop.controller.EmployeeController.fetchEmployee())")
    public void afterMethod()
    {
        log.info("inside after  method Aspect");
    }

    @Before("execution(public int com.learning.aop.controller.EmployeeController.fetchEmployeeWithId(*))")
    public void fetchEmployeeWithParam()
    {
        log.info("EmployeeController.fetchEmployee(*) invoked");
    }
    @Before("execution(public * com.learning.aop.controller.EmployeeController.fetchEmployeeWithId(..))")
    public void fetchEmployeeWithMultipleParam()
    {
        log.info("EmployeeController.fetchEmployee(..) invoked");
    }
    @Before("within(com.learning.aop.controller.EmployeeController)")
    public void fetchLogsForAll()
    {
        log.info("EmployeeController.Aspect 1 invoked in current Package");
    }
    @Before("within(com.learning.aop..*)")
    public void fetchLogsForAllPackageAndSubPackage()
    {
        log.info("EmployeeController.Aspect 2 invoked in current SubPackage");
    }
    @Before("@within(org.springframework.stereotype.Service)")
    public void classLevelAnnotationMatcher()
    {
        log.info("Service annotation invoked");
    }
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void methodLevelAnnotationMatcher()
    {
        log.info("GetMapping annotation  touched");
    }
    @Before("args(int,String)")
    public void matchArgsStringAndInteger()
    {
        log.info("Args Match Invoked with int,String");
    }
//    @Before("args(com.learning.aop.model.FoodDto)")
//    public void matchArgsWithFoodDto()
//    {
//        log.info("Args Match Invoked with FoodDto.class");
//    }
//    @Before("@args(org.springframework.stereotype.Service)")
//    public void matchWithServiceAnnotation()
//    {
//        log.info("Args Match Invoked with FoodDto.class");
//    }
    @Before("target(com.learning.aop.service.JunkService)")
    public void targetMatchWithJunkService()
    {
        log.info("method called with this <JunkService> particular instance");
    }
    @Before("target(com.learning.aop.service.EmployeeService)")
    public void targetMatchWithEmployeeService()
    {
        log.info("method called with this <Employee> particular instance");
    }
    @Before("target(com.learning.aop.service.Employee)")
    public void targetMatchWithEmployeeInterface()
    {
        log.info("method called with this <Employee> particular interface");
    }

    @Before("@within(org.springframework.stereotype.Service)"
            +"&& target(com.learning.aop.service.JunkService)")
    //when combining point cuts it needs to refer to the same class then only they work
    public void anyMethodInEmployeeController()
    {
        log.info("Any Method invoked in EmployeeController");
    }

    @Pointcut("target(com.learning.aop.service.JunkService)")
    void customPointCutForJunkService()
    {
        //creating a custom point cut for JunkService instance
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    void customPointCutForServiceAnnotation()
    {
        //creating @Service PointCut
    }

    @Before("customPointCutForJunkService()")
    void customPointCutImplementation()
    {
        log.info("Implementation of custom point cut");
    }





}
