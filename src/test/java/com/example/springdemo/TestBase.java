package com.example.springdemo;

import com.example.springdemo.framework.driver.DriverService;
import com.example.springdemo.framework.navigation.NavigationService;
import com.example.springdemo.framework.wait_strategy.WaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public abstract class TestBase extends AbstractTestNGSpringContextTests {
  @Autowired protected DriverService driverService;
  @Autowired protected WaitService waitService;
  @Autowired protected NavigationService navigationService;

  @BeforeSuite
  public void setup() {
    //
  }

  @BeforeMethod
  public void beforeTest() {
    driverService.start();
    waitService.start();
  }

  @AfterMethod
  public void afterTest() {
    driverService.quit();
  }

  @AfterSuite
  public void tearDown() {
    //
  }
}
