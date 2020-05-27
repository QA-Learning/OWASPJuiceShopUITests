package com.example.tests;

import com.example.config.PageObjectBeanPostProcessor;
import com.example.config.SpringConfig;
import com.example.pageobjects.BeanPageObjects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PageObjectBeanPostProcessor.class,
    BeanPageObjects.class, SpringConfig.class,
    AutowiredAnnotationBeanPostProcessor.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {

    @Autowired
    protected WebDriver driver;

    @Value("${baseurl}")
    private String baseurl;

    @Value("${valid_username}")
    protected String validUserName;

    @Value("${invalid_username}")
    protected String invalidUserName;

    @Value("${password}")
    protected String password;

    @BeforeEach
    public void setup() {
        driver.get(baseurl);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
