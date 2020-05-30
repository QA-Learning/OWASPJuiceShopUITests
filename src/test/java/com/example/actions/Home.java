package com.example.actions;

import com.example.elements.HomeHeaderElements;
import com.example.elements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Home  extends Base {
    public Home(WebDriver driver) {
        super(driver);
    }

    public Home skipBanner() {
        findElement(HomeHeaderElements.welcomeBanner).click();
        return this;
    }

    public boolean isLoggedIn() {
        findElement(HomeHeaderElements.myAccount).click();
        return findElement(HomeHeaderElements.logoutButton).isDisplayed();
    }

    public void navigateToLogin() {
        findElement(HomeHeaderElements.myAccount).click();
        findElement(HomeHeaderElements.login).click();
    }
}
