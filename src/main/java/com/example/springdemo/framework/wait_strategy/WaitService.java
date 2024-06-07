package com.example.springdemo.framework.wait_strategy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import com.example.springdemo.Configuration;
import com.example.springdemo.framework.driver.DriverService;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitService {
  @Autowired DriverService driverService;
  private static WebDriverWait webDriverWait;

  public void start() {
    WebDriver driver = driverService.getWrappedDriver();
    Duration defaultTimeout = Configuration.DEFAULT_TIMEOUT_DURATION;
    webDriverWait = new WebDriverWait(driver, defaultTimeout);
  }

  public void waitForVisibilityOfElement(WebElement webElement) {
    webDriverWait.until(visibilityOf(webElement));
  }

  @OptionalTimeout
  @SuppressWarnings("unused")
  public void waitForVisibilityOfElement(int timeout, WebElement webElement) {
    waitForVisibilityOfElement(webElement);
  }

  public void waitForInvisibilityOfElement(WebElement webElement) {
    webDriverWait.until(invisibilityOf(webElement));
  }

  @OptionalTimeout
  @SuppressWarnings("unused")
  public void waitForInvisibilityOfElement(int timeout, WebElement webElement) {
    waitForInvisibilityOfElement(webElement);
  }

  public void waitForElementToBeClickable(WebElement webElement) {
    webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
  }

  @OptionalTimeout
  @SuppressWarnings("unused")
  public void waitForElementToBeClickable(int timeout, WebElement webElement) {
    waitForElementToBeClickable(webElement);
  }

  void setTimeout(Duration duration) {
    webDriverWait.withTimeout(duration);
    System.out.println("Set timeout to " + duration);
  }
}
