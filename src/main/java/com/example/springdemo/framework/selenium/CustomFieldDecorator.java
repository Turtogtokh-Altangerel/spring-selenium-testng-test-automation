package com.example.springdemo.framework.selenium;

import com.example.springdemo.framework.SpringContextBridge;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class CustomFieldDecorator extends DefaultFieldDecorator {

  public CustomFieldDecorator(SearchContext searchContext) {
    super(new DefaultElementLocatorFactory(searchContext));
  }

  @Override
  protected WebElement proxyForLocator(ClassLoader loader, ElementLocator locator) {
    WebElement proxy = super.proxyForLocator(loader, locator);
    WebElementProxy webElementProxy = SpringContextBridge.getBean(WebElementProxy.class);
    return webElementProxy.createProxy(proxy);
  }
}
