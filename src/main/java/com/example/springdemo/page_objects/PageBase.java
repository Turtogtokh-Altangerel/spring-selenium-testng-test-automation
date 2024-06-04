package com.example.springdemo.page_objects;

import com.example.springdemo.framework.driver.DriverService;
import com.example.springdemo.framework.selenium.CustomFieldDecorator;
import com.example.springdemo.framework.wait_strategy.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PageBase {
  @Autowired protected WaitHelper waitHelper;
  @Autowired protected DriverService driverService;

  protected WebDriver driver;

  protected PageBase() {}

  protected void init() {
    driver = driverService.getWrappedDriver();
    PageFactory.initElements(new CustomFieldDecorator(driver), this);
  }
}
