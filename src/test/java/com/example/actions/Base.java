package com.example.actions;

import org.openqa.selenium.WebElement;

import java.util.function.Predicate;

import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;

public class Base {
    Predicate<WebElement> isElementLocated = WebElement::isDisplayed;

    public WebElement findElement(WebElement element) {
        await().atMost(ofSeconds(20))
                .pollInterval(ofSeconds(1))
                .ignoreExceptions()
                .until(() -> isElementLocated.test(element));
        return element;
    }
}
