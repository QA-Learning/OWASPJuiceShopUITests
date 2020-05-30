package com.example.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
class JuiceShopJunitTest extends BaseTest {

    private String email;

    @BeforeEach
    public void setup() {
        driver.get(baseurl);
        home().skipBanner().navigateToLogin();
        email = userEmail();
        newCustomer().registerNewCustomer(email, password);
    }

    @Test
    void shouldBeAbleLoginWithValidCredentials() {
        login().withValidCredentials(email, password);
        assertThat(home().isLoggedIn()).isTrue();
    }

    @Test
    void ShouldNotBeAbleToLoginWithInValidCredentials() {
        assertThat(login().withInvalidCredentials(invalidUserName, password))
            .isEqualTo("Invalid email or password.");
    }

    @Test
    void shouldBeAbleToAddAndRemoveItemToBasket() {
        login().withValidCredentials(email, password);
        basket().addItem();
        assertThat(basket().didSnackBarShowUp()).isTrue();
        basket().removeItem();
        assertThat(basket().isBasketEmpty()).isTrue();
    }

    private String userEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username" + randomInt + "@gmail.com";
    }
}
