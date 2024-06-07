package com.example.springdemo.framework.selenium;

import com.example.springdemo.framework.wait_strategy.WaitService;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebElementAspect {
  @Autowired WaitService waitService;

  @Before("allMethods()")
  public void before(JoinPoint joinPoint) {
    WebElement element = (WebElement) joinPoint.getTarget();
    waitService.waitForVisibilityOfElement(element);
    String name = ((ShortNamedWebElement) element).getName();
    System.out.println("Waited for visibility of " + name);
  }

  @Before("execution(* org.openqa.selenium.WebElement.click())")
  public void beforeClick(JoinPoint joinPoint) {
    WebElement element = (WebElement) joinPoint.getTarget();
    waitService.waitForElementToBeClickable(element);

    String name = ((ShortNamedWebElement) element).getName();
    System.out.println("Waited for " + name + " to be clickable");
  }

  @After("execution(* org.openqa.selenium.WebElement.click())")
  public void afterClick(JoinPoint joinPoint) {
    String name = ((ShortNamedWebElement) joinPoint.getTarget()).getName();
    System.out.println("Clicked on " + name);
  }

  @After("execution(* org.openqa.selenium.WebElement.sendKeys(..)) && args(keys)")
  public void afterSendKeys(JoinPoint joinPoint, CharSequence[] keys) {
    String name = ((ShortNamedWebElement) joinPoint.getTarget()).getName();
    System.out.println("Sent " + Arrays.toString(keys) + " to " + name);
  }

  @Pointcut("execution(* org.openqa.selenium.WebElement.*(..))")
  public void allMethods() {}
}
