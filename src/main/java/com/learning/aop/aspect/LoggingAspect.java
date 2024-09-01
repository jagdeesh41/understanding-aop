package com.learning.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
        log.info("EmployeeController.Aspect 1 invoked");
    }
    @Before("within(com.learning.aop..*)")
    public void fetchLogsForAllPackageAndSubPackage()
    {
        log.info("EmployeeController.Aspect 2 invoked");
    }


}
