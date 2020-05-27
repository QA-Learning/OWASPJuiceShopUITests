package com.example.actions;

import com.example.pageobjects.AbstractPageAndObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;

@Component
@Scope("prototype")
public class Basket extends AbstractPageAndObjects {


    public void addItem() {
        findElement(basketPageObjects.addToBasket).click();
    }

    public void removeItem() {
        findElement(basketPageObjects.snackBar);
        findElement(basketPageObjects.cart).click();
        findElement(basketPageObjects.quantity);
        findElement(basketPageObjects.removeButton).click();
    }

    public boolean didSnackBarShowUp() {
        return findElement(basketPageObjects.snackBar).isDisplayed();
    }

    public boolean isBasketEmpty() {
        Predicate<WebElement> isCheckoutEnabled = WebElement::isEnabled;
        WebElement checkoutButton = basketPageObjects.checkout;
        await().atMost(ofSeconds(20))
            .pollInterval(ofSeconds(1))
            .ignoreExceptions()
            .until(() -> !isCheckoutEnabled.test(checkoutButton));
        return !checkoutButton.isEnabled();
    }
}
