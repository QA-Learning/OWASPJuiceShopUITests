package com.example.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Login extends Base {

    public Login(WebDriver driver) {
        super(driver);
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
        findElement(myAccount).click();
        return findElement(logoutButton).isDisplayed();
    }

    public String withInvalidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
        return findElement(error).getText();
    }

    private void loginWithEmailAndPassword(String emailId, String password) {
        findElement(welcomeBanner).click();
        findElement(myAccount).click();
        findElement(login).click();
        findElement(email).sendKeys(emailId);
        findElement(pass).sendKeys(password);
        findElement(loginButton).click();
    }
}
