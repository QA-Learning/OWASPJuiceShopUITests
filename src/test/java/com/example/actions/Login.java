package com.example.actions;

import com.example.pageobjects.AbstractPageAndObjects;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Login extends AbstractPageAndObjects {

    public void withValidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
    }

    public boolean isLoggedIn() {
        findElement(loginPageObjects.myAccount).click();
        return loginPageObjects.logoutButton.isDisplayed();
    }

    public String withInvalidCredentials(String emailId, String password) {
        loginWithEmailAndPassword(emailId, password);
        return findElement(loginPageObjects.error).getText();
    }

    private void loginWithEmailAndPassword(String emailId, String password) {
        findElement(loginPageObjects.welcomeBanner).click();
        findElement(loginPageObjects.myAccount).click();
        findElement(loginPageObjects.login).click();
        findElement(loginPageObjects.emailID).click();
        findElement(loginPageObjects.emailID).sendKeys(emailId);
        findElement(loginPageObjects.pass).sendKeys(password);
        findElement(loginPageObjects.loginButton).click();
    }
}
