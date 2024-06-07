package com.example.springdemo.framework.selenium;

import com.example.springdemo.framework.SpringContextBridge;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
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
  public Object decorate(ClassLoader loader, Field field) {
    if (!(WebElement.class.isAssignableFrom(field.getType()) || isDecoratableList(field))) {
      return null;
    }

    ElementLocator locator = factory.createLocator(field);
    if (locator == null) {
      return null;
    }

    if (WebElement.class.isAssignableFrom(field.getType())) {
      // LocatingElementHandler
      WebElement proxyForLocator = proxyForLocator(loader, locator);
      // ShortNamedElementHandler
      WebElement proxyForName = proxyForName(loader, proxyForLocator, field.getName());
      //       WebElementAspect
      return SpringContextBridge.getBean(WebElementProxy.class).proxyForAspect(proxyForName);
    } else if (List.class.isAssignableFrom(field.getType())) {
      return proxyForListLocator(loader, locator);
    } else {
      return null;
    }
  }

  private WebElement proxyForName(ClassLoader loader, WebElement element, String name) {
    InvocationHandler handler = new ShortNamedElementHandler(element, name);

    return (ShortNamedWebElement)
        Proxy.newProxyInstance(loader, new Class[] {ShortNamedWebElement.class}, handler);
  }
}
