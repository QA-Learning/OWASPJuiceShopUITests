package com.example.elements;

import org.openqa.selenium.By;

public class BasketElements {

    public static By addToBasket = By.xpath("(//button[contains(@aria-label,'Add to Basket')])[1]");
    public static By cart = By.xpath("//button[@aria-label='Show the shopping cart']");
    public static By snackBar = By.className("mat-simple-snackbar");
    public static By checkout = By.id("checkoutButton");
    public static By quantity = By.className("mat-icon-button");
    public static By removeButton = By.xpath("//mat-cell[contains(@class,'mat-column-remove')]/button");
}
