package com.example.springdemo.page_objects;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@PageObject(defaultUrl = "https://www.saucedemo.com/")
public class SwagLabsLandingPage extends PageBase {
  @FindBy(how = How.CLASS_NAME, using = "login_logo")
  private WebElement loginLogo;

  @FindBy(id = "user-name")
  private WebElement usernameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @PostConstruct
  public void init() {
    super.init();
  }

  public void typeUsername(String username) {
    usernameField.sendKeys(username);
  }

  public void typePassword(String password) {
    passwordField.sendKeys(password);
  }

  public void clickLogin() {
    loginButton.click();
  }
}
