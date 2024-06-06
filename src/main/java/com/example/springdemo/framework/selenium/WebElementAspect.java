package com.example.springdemo.framework.selenium;

import com.example.springdemo.framework.wait_strategy.WaitHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebElementAspect {
  @Autowired WaitHelper waitHelper;

  @Before("allMethods()")
  public void before(JoinPoint joinPoint) {
    WebElement element = (WebElement) joinPoint.getTarget();
    waitHelper.waitForVisibilityOfElement(element);
  }

  @Pointcut("execution(* org.openqa.selenium.WebElement.*(..))")
  public void allMethods() {}
}
