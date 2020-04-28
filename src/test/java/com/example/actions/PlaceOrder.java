package com.example.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
@Scope("prototype")
public class PlaceOrder extends Login {

    private WebDriverWait wait;

    private By addToBasket = By.xpath("(//button[contains(@aria-label,'Add to Basket')])[1]");
    private By cart = By.xpath("//button[@aria-label='Show the shopping cart']");
    private By snackBar = By.className("mat-simple-snackbar");
    private By checkout = By.id("checkoutButton");
    private By quantity = By.className("mat-icon-button");
    private By productImage = By.className("mat-card-image");
    private By searchIcon = By.className("mat-search_icon-search");
    private By search = By.className("mat-input-element");

    public PlaceOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, ofSeconds(20));
    }

    public void addItemToBasket() {
        wait.until(elementToBeClickable(addToBasket)).click();
    }

    public boolean didSnackBarShowUp() {
        return wait.until(visibilityOfElementLocated(snackBar)).isDisplayed();
    }

    public boolean checkBasket() {
        wait.until(visibilityOfElementLocated(snackBar));
        wait.until(elementToBeClickable(cart)).click();
        wait.until(visibilityOfElementLocated(quantity));
        return wait.until(elementToBeClickable(checkout)).isEnabled();
    }

    public boolean searchProducts(String text) {
        wait.until(elementToBeClickable(searchIcon)).click();
        wait.until(elementToBeClickable(search)).sendKeys(text + "\n");
        return wait.until(elementToBeClickable(productImage)).isDisplayed();
    }
}
