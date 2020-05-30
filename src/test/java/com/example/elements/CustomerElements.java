package com.example.elements;

import org.openqa.selenium.By;

public class CustomerElements {

    public static By newCustomerLink = By.id("newCustomerLink");
    public static By email = By.id("emailControl");
    public static By password = By.id("passwordControl");
    public static By repeatPassword = By.id("repeatPasswordControl");
    public static By selectOption = By.xpath(".//*[contains(@class,'mat-option-text')]");
    public static By openDropDown = By.className("mat-select-arrow");
    public static By securityAnswer = By.id("securityAnswerControl");
    public static By registerButton = By.id("registerButton");
}
