package com.example.springdemo.framework.navigation;

import com.example.springdemo.framework.SpringContextBridge;
import com.example.springdemo.framework.driver.DriverService;
import com.example.springdemo.page_objects.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigationService {
  @Autowired DriverService driverService;

  public <T> T to(Class<T> page) {
    if (!page.isAnnotationPresent(PageObject.class)) {
      throw new IllegalArgumentException(
          page.getSimpleName() + " does not have PageObject annotation");
    }
    String url = page.getAnnotation(PageObject.class).defaultUrl();
    driverService.getWrappedDriver().navigate().to(url);
    return SpringContextBridge.getBean(page);
  }
}
