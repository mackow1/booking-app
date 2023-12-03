package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseCredentialsTest {

    @Test
    void givenKeyUrl_whenGetProperty_thenValueNotNull() {
        // given
        String key = "url";

        // when
        String value = DatabaseCredentials.getPropertyValue(key);

        // then
        Assertions.assertNotNull(value, "Value is null");
    }

    @Test
    void givenKeyUser_whenGetProperty_thenValueNotNull() {
        // given
        String key = "user";

        // when
        String value = DatabaseCredentials.getPropertyValue(key);

        // then
        Assertions.assertNotNull(value, "Value is null");
    }

    @Test
    void givenKeyPassword_whenGetProperty_thenValueNotNull() {
        // given
        String key = "password";

        // when
        String value = DatabaseCredentials.getPropertyValue(key);

        // then
        Assertions.assertNotNull(value, "Value is null");
    }
}