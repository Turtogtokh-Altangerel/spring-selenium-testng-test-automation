package com.example.springdemo;

import com.example.springdemo.framework.driver.DriverService;
import com.example.springdemo.framework.wait_strategy.WaitHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public abstract class TestBase extends AbstractTestNGSpringContextTests {
  @Autowired protected DriverService driver;
  @Autowired protected WaitHelper waitHelper;

  @BeforeSuite
  public void setup() {
    //
  }

  @BeforeMethod
  public void beforeTest() {
    driver.start();
    waitHelper.start();
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
