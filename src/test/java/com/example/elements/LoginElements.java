package com.example.elements;

import org.openqa.selenium.By;

public class LoginElements {

    public static By email = By.id("email");
    public static By pass = By.id("password");
    public static By loginButton = By.id("loginButton");
    public static By logoutButton = By.id("navbarLogoutButton");
    public static By error = By.className("error");
    public static By welcomeBanner = By.xpath("(//button[contains(@aria-label,'Close Welcome Banner')])[1]");
    public static By myAccount = By.id("navbarAccount");
    public static By login = By.id("navbarLoginButton");
}
