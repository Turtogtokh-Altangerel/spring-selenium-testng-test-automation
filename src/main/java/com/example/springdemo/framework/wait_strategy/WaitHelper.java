package com.example.springdemo.framework.wait_strategy;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
public class WaitHelper {
  public void waitForVisibilityOfElement(WebElement webElement) {
    //
  }

  @OptionalTimeout
  @SuppressWarnings("unused")
  public void waitForVisibilityOfElement(int timeout, WebElement webElement) {
    waitForVisibilityOfElement(webElement);
  }

  public void waitForInvisibilityOfElement(WebElement webElement) {
    //
  }

  @OptionalTimeout
  @SuppressWarnings("unused")
  public void waitForInvisibilityOfElement(int timeout, WebElement webElement) {
    waitForInvisibilityOfElement(webElement);
  }
}
