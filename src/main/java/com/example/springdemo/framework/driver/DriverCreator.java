package com.example.springdemo.framework.driver;

import com.example.springdemo.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverCreator {
  CHROME {
    public WebDriver createDriver() {
      return new ChromeDriver();
    }
  },
  FIREFOX {
    public WebDriver createDriver() {
      return new FirefoxDriver();
    }
  };

  public abstract WebDriver createDriver();

  public static WebDriver create() {
    return valueOf(Configuration.DRIVER_TYPE.toUpperCase()).createDriver();
  }
}
