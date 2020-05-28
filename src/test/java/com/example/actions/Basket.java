package com.example.actions;

import com.example.elements.BasketElements;
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
public class Basket extends Base {

    private WebDriver driver;

    public Basket(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void addItem() {
        findElement(BasketElements.addToBasket).click();
    }

    public void removeItem() {
        findElement(BasketElements.snackBar);
        findElement(BasketElements.cart).click();
        findElement(BasketElements.quantity);
        findElement(BasketElements.removeButton).click();
    }

    public boolean didSnackBarShowUp() {
        return findElement(BasketElements.snackBar).isDisplayed();
    }

    public boolean isBasketEmpty() {
        Predicate<WebElement> isCheckoutEnabled = WebElement::isEnabled;
        WebElement checkoutButton = driver.findElement(BasketElements.checkout);
        await().atMost(ofSeconds(20))
                .pollInterval(ofSeconds(1))
                .ignoreExceptions()
                .until(() -> !isCheckoutEnabled.test(checkoutButton));
        return !checkoutButton.isEnabled();
    }
}
