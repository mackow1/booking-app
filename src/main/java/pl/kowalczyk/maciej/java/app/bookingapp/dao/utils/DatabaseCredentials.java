package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCredentials {

    private static DatabaseCredentials instance;
    private static final Logger LOGGER = Logger.getLogger(DatabaseCredentials.class.getName());

    private DatabaseCredentials() {

    }

    public static DatabaseCredentials getInstance() {
        LOGGER.info("getInstance()");
        if (instance == null) {
            instance = new DatabaseCredentials();
        }
        LOGGER.info("getInstance(...) = " + instance);
        return instance;
    }

    // TODO: 01.12.2023 PD
    // Refactor: z 3 metod zrobić 1 przyjmującą parametr / albo singleton

    public static String getPropertyValue(String key) {
        LOGGER.info("getPropertyValue(" + key + ")");
        String propertyValue = null;
        Properties properties = new Properties();

        try (FileInputStream in = new FileInputStream("src/main/resources/database.properties")) {
            properties.load(in);
            propertyValue = properties.getProperty(key);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        LOGGER.info("getPropertyValue(...) = " + propertyValue);
        return propertyValue;
    }
}
