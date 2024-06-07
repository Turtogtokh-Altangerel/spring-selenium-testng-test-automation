package com.example.springdemo.framework.selenium;

import org.openqa.selenium.WebElement;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebElementProxy {
  @Autowired private WebElementAspect webElementAspect;

  public WebElement proxyForAspect(WebElement element) {
    AspectJProxyFactory proxyFactory = new AspectJProxyFactory(element);
    proxyFactory.addAspect(webElementAspect);
    return proxyFactory.getProxy();
  }
}
