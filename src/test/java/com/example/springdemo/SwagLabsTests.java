package com.example.springdemo;

import com.example.springdemo.page_objects.SwagLabsLandingPage;
import org.testng.annotations.Test;

public class SwagLabsTests extends TestBase {
  @Test
  public void loginTest() {
    var loginPage = navigationService.to(SwagLabsLandingPage.class);
    loginPage.typeUsername("standard_user");
    loginPage.typePassword("secret_sauce");
    loginPage.clickLogin();
  }
}
