package com.example.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class JuiceShopJunitTest extends BaseTest {

    @Test
    void shouldBeAbleLoginWithValidCredentials() {
        login().withValidCredentials(validUserName, password);
        assertThat(login().isLoggedIn()).isTrue();
    }

    @Test
    void ShouldNotBeAbleToLoginWithInValidCredentials() {
        assertThat(login().withInvalidCredentials(invalidUserName, password))
                .isEqualTo("Invalid email or password.");
    }

    @Test
    void shouldBeAbleToAddAndRemoveItemToBasket() {
        login().withValidCredentials(validUserName, password);
        basket().addItem();
        assertThat(basket().didSnackBarShowUp()).isTrue();
        basket().removeItem();
        assertThat(basket().isBasketEmpty()).isTrue();
    }
}
