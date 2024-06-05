package com.example.springdemo;

import com.example.springdemo.page_objects.DummyPage;
import org.testng.annotations.Test;

public class DummyTests extends TestBase {
  @Test
  public void dummyTest() {
    System.out.println("Starting the test");
    getBean(DummyPage.class).clickOnDummyElement();
    System.out.println("Finishing the test");
  }
}
