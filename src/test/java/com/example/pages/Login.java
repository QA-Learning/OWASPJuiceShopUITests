package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
@Scope("prototype")
public class Login {

    private WebDriverWait wait;

    public Login(WebDriver driver) {
        this.wait = new WebDriverWait(driver, ofSeconds(20));
    }

    private By email = By.id("email");
    private By pass = By.id("password");
    private By loginButton = By.id("loginButton");
    private By logoutButton = By.id("navbarLogoutButton");
    private By error = By.className("error");
    private By welcomeBanner = By.xpath("(//button[contains(@aria-label,'Close Welcome Banner')])[1]");
    private By myAccount = By.id("navbarAccount");
    private By login = By.id("navbarLoginButton");

    public void withValidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
    }

    public boolean isLoggedIn() {
        wait.until(elementToBeClickable(myAccount)).click();
        return wait.until(elementToBeClickable(logoutButton)).isDisplayed();
    }

    public String withInvalidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
        return wait.until(elementToBeClickable(error)).getText();
    }

    private void loginWithEmailAndPassword(String emailId, String password) {
        clickLogin();
        wait.until(presenceOfElementLocated(email)).sendKeys(emailId);
        wait.until(presenceOfElementLocated(pass)).sendKeys(password);
        wait.until(elementToBeClickable(loginButton)).click();
    }

    private void clickLogin() {
        wait.until(elementToBeClickable(welcomeBanner)).click();
        wait.until(elementToBeClickable(myAccount)).click();
        wait.until(elementToBeClickable(login)).click();
    }
}
