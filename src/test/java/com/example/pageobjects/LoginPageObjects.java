package com.example.pageobjects;

import com.example.annotations.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class LoginPageObjects {

    @FindBy(id = "email")
    public WebElement emailID;

    @FindBy(id = "password")
    public WebElement pass;

    @FindBy(id = "loginButton")
    public WebElement loginButton;


    @FindBy(id = "navbarLogoutButton")
    public WebElement logoutButton;


    @FindBy(className = "error")
    public WebElement error;

    @FindBy(xpath = "(//button[contains(@aria-label,'Close Welcome Banner')])[1]")
    public WebElement welcomeBanner;


    @FindBy(id = "navbarAccount")
    public WebElement myAccount;


    @FindBy(id = "navbarLoginButton")
    public WebElement login;
}

