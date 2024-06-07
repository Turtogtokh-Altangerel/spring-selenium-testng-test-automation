package com.example.springdemo.framework.selenium;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebElement;

public class ShortNamedElementHandler implements InvocationHandler {
  private final WebElement element;
  private final String name;

  public ShortNamedElementHandler(WebElement element, String name) {
    this.element = element;
    // transform camel case string
    this.name = name.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2").toLowerCase();
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.getName().equals("getName")) {
      return this.name;
    }
    try {
      return method.invoke(element, args);
    } catch (InvocationTargetException e) {
      throw e.getCause();
    }
  }
}
