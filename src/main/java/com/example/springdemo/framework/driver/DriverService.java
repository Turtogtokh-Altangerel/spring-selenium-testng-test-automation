package com.example.springdemo.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.springframework.stereotype.Service;

@Service
public class DriverService implements WrapsDriver {
  public static WebDriver webDriver;

  public void start() {
    webDriver = DriverCreator.create();
  }

  public void quit() {
    webDriver.quit();
  }

  @Override
  public WebDriver getWrappedDriver() {
    return webDriver;
  }
}
