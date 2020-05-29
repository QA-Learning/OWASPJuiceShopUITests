package com.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriver getDriver() {
        String browser = System.getenv("BROWSER");
            switch (browser) {
                case "IE":
                    WebDriverManager.iedriver().setup();
                    return new InternetExplorerDriver();
                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case "REMOTE":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("browserName", "chrome");

                    try {
                        return new RemoteWebDriver(new URL("http://hub.com:4444/wd/hub"),
                            capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                default:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
            }
        }
    }
