package com.example.actions;

import com.example.elements.CustomerElements;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NewCustomer extends Base {

    public NewCustomer(WebDriver driver) {
        super(driver);
    }

    public void registerNewCustomer(String email, String password) {
         findElement(CustomerElements.newCustomerLink).click();
         findElement(CustomerElements.email).sendKeys(email);
         findElement(CustomerElements.password).sendKeys(password);
         findElement(CustomerElements.repeatPassword).sendKeys(password);
         findElement(CustomerElements.openDropDown).click();
         findElement(CustomerElements.selectOption).click();
         findElement(CustomerElements.securityAnswer).sendKeys("Test");
         findElement(CustomerElements.registerButton).click();
    }
}
