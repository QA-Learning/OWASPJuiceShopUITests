package com.example.pageobjects;

import com.example.annotations.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@PageObject
public class BasketPageObjects {

    @FindBy(xpath = "(//button[contains(@aria-label,'Add to Basket')])[1]")
    public WebElement addToBasket;

    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    public WebElement cart;

    @FindBy(className = "mat-simple-snackbar")
    public WebElement snackBar;


    @FindBy(id = "checkoutButton")
    public WebElement checkout;

    @FindBy(xpath = "//*[contains(@class,'mat-icon-button')]")
    public WebElement quantity;

    @FindBy(xpath = "//mat-cell[contains(@class,'mat-column-remove')]/button")
    public WebElement removeButton;
}
