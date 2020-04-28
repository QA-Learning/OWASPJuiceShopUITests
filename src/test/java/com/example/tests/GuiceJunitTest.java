package com.example.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class GuiceJunitTest extends BaseTest {

    @Test
    void shouldBeAbleLoginWithValidCredentials() {
        login().withValidCredentials("asd@asd.com", "password");
        assertThat(login().isLoggedIn()).isTrue();
    }

    @Test
    void ShouldNotBeAbleToLoginWithInValidCredentials() {
        assertThat(login().withInvalidCredentials("asasdd@asd.com", "password"))
                .isEqualTo("Invalid email or password.");
    }

    @Test
    void shouldBeAbleToAddItemToBasket() {
        login().withValidCredentials("asd@asd.com", "password");
        getPlaceOrder().addItemToBasket();
        assertThat(getPlaceOrder().didSnackBarShowUp()).isTrue();
    }
}
