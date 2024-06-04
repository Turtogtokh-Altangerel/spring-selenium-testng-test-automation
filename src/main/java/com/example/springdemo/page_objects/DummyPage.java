package com.example.springdemo.page_objects;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class DummyPage extends PageBase {
  @FindBy(xpath = "//*")
  private WebElement dummyElement;

  @PostConstruct
  public void init() {
    super.init();
  }

  public void clickOnDummyElement() {
    dummyElement.click();
  }
}
