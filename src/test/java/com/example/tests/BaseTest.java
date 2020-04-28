package com.example.tests;

import com.example.config.SpringConfig;
import com.example.pages.Login;
import com.example.pages.PlaceOrder;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        SpringConfig.class,
})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {

    @Autowired
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver.get("https://juice-shop.herokuapp.com/#/");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @NotNull
    protected Login login() {
        return new Login(driver);
    }

    @NotNull
    protected PlaceOrder getPlaceOrder() {
        return new PlaceOrder(driver);
    }
}
