package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void getConnection() throws SQLException {
        // given
        // when
        Connection connection = DatabaseConnection.getInstance().getConnection();

        // then
        Assertions.assertNotNull(connection, "Connection is null");
    }

    @Test
    void getInstance() {
        // given
        // when
        DatabaseConnection firstInstance = DatabaseConnection.getInstance();
        DatabaseConnection secondInstance = DatabaseConnection.getInstance();

        // then
        Assertions.assertEquals(firstInstance, secondInstance, "Instances are not equal");
    }
}