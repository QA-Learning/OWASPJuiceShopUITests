package com.example.tests;

import com.example.config.SpringConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(classes = {
        SpringConfig.class,
})
public class TestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebDriver driver;

    @Test
    void test1() {
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());
        driver.get("https://juice-shop.herokuapp.com/#/");
        driver.close();
        driver.quit();
    }

    @Test
    void test2() {
        System.out.println("Test Case two with Thread Id:- "
                + Thread.currentThread().getId());
        driver.get("https://juice-shop.herokuapp.com/#/");
        driver.close();
        driver.quit();
    }


}
