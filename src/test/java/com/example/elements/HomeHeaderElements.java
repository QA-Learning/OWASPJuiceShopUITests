package com.example.elements;

import org.openqa.selenium.By;

public class HomeHeaderElements {
    public static By welcomeBanner = By.xpath("(//button[contains(@aria-label,'Close Welcome Banner')])[1]");
    public static By myAccount = By.id("navbarAccount");
    public static By login = By.id("navbarLoginButton");
    public static By logoutButton = By.id("navbarLogoutButton");

}
