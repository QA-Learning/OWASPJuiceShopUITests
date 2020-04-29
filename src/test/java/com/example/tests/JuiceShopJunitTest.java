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
    void shouldBeAbleToAddItemToBasket() {
        login().withValidCredentials(validUserName, password);
        getPlaceOrder().addItemToBasket();
        assertThat(getPlaceOrder().didSnackBarShowUp()).isTrue();
    }
}
