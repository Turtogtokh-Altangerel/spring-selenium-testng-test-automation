package com.example.springdemo.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

  private enum DriverSetup {
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
  }
}
