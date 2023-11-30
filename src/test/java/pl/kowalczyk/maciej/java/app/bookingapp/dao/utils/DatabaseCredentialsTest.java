package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseCredentialsTest {

    @Test
    void getUrl() {
        // given
        // when
        String url = DatabaseCredentials.getUrl();

        // then
        Assertions.assertNotNull(url, "URL is null");
    }

    @Test
    void getUser() {
        // given
        // when
        String user = DatabaseCredentials.getUser();

        // then
        Assertions.assertNotNull(user, "User is null");
    }
}