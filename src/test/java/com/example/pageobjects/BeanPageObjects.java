package com.example.pageobjects;

import com.example.actions.Base;
import com.example.actions.Basket;
import com.example.actions.Login;
import org.springframework.context.annotation.Bean;

public class BeanPageObjects {

    @Bean
    public LoginPageObjects loginPageObjects() {
        return new LoginPageObjects();
    }

    @Bean
    public BasketPageObjects basketPageObjects() {
        return new BasketPageObjects();
    }

    @Bean
    public Login login() {
        return new Login();
    }

    @Bean
    public Basket basket() {
        return new Basket();
    }

    @Bean
    public Base base() {
        return new Base();
    }
}
