package com.example.tests;

import com.example.actions.Basket;
import com.example.actions.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class JuiceShopJunitTest extends BaseTest {

    @Autowired
    Login login;

    @Autowired
    Basket basket;

    @Test
    void shouldBeAbleLoginWithValidCredentials() {
        login.withValidCredentials(validUserName, password);
        assertThat(login.isLoggedIn()).isTrue();
    }

    @Test
    void ShouldNotBeAbleToLoginWithInValidCredentials() {
        assertThat(login.withInvalidCredentials(invalidUserName, password))
                .isEqualTo("Invalid email or password.");
    }

    @Test
    void shouldBeAbleToAddAndRemoveItemToBasket() {
        login.withValidCredentials(validUserName, password);
        basket.addItem();
        assertThat(basket.didSnackBarShowUp()).isTrue();
        basket.removeItem();
        assertThat(basket.isBasketEmpty()).isTrue();
    }
}
