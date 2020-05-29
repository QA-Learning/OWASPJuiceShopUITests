package com.example.actions;

import com.example.elements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Login extends Base {

    public Login(WebDriver driver) {
        super(driver);
    }

    public void withValidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
    }

    public boolean isLoggedIn() {
        findElement(LoginElements.myAccount).click();
        return findElement(LoginElements.logoutButton).isDisplayed();
    }

    public String withInvalidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
        return findElement(LoginElements.error).getText();
    }

    private void loginWithEmailAndPassword(String emailId, String password) {
        findElement(LoginElements.welcomeBanner).click();
        findElement(LoginElements.myAccount).click();
        findElement(LoginElements.login).click();
        findElement(LoginElements.email).sendKeys(emailId);
        findElement(LoginElements.pass).sendKeys(password);
        findElement(LoginElements.loginButton).click();
    }
}
