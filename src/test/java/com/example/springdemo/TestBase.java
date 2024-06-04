package com.example.springdemo;

import com.example.springdemo.framework.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public abstract class TestBase extends AbstractTestNGSpringContextTests {
  @Autowired protected DriverService driver;

  @BeforeSuite
  public void setup() {
    //
  }

  @BeforeMethod
  public void beforeTest() {
    driver.start();
  }

  @AfterMethod
  public void afterTest() {
    driver.quit();
  }

  @AfterSuite
  public void tearDown() {
    //
  }

  protected <T> T getPage(Class<T> page) {
    assert applicationContext != null;
    return applicationContext.getBean(page);
  }
}
