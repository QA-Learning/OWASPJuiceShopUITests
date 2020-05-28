package com.example.actions;

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

    private By addToBasket = By.xpath("(//button[contains(@aria-label,'Add to Basket')])[1]");
    private By cart = By.xpath("//button[@aria-label='Show the shopping cart']");
    private By snackBar = By.className("mat-simple-snackbar");
    private By checkout = By.id("checkoutButton");
    private By quantity = By.className("mat-icon-button");
    private By removeButton = By.xpath("//mat-cell[contains(@class,'mat-column-remove')]/button");

    public void addItem() {
        findElement(addToBasket).click();
    }

    public void removeItem() {
        findElement(snackBar);
        findElement(cart).click();
        findElement(quantity);
        findElement(removeButton).click();
    }

    public boolean didSnackBarShowUp() {
        return findElement(snackBar).isDisplayed();
    }

    public boolean isBasketEmpty() {
        Predicate<WebElement> isCheckoutEnabled = WebElement::isEnabled;
        WebElement checkoutButton = driver.findElement(checkout);
        await().atMost(ofSeconds(20))
                .pollInterval(ofSeconds(1))
                .ignoreExceptions()
                .until(() -> !isCheckoutEnabled.test(checkoutButton));
        return !checkoutButton.isEnabled();
    }
}
