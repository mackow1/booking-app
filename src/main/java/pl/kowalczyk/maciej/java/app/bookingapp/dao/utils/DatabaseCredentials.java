package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCredentials {

    private static final Logger LOGGER = Logger.getLogger(DatabaseCredentials.class.getName());

    private static Properties properties = new Properties();

    static {
        try (FileInputStream in = new FileInputStream("src/main/resources/database.properties")) {
            properties.load(in);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }


    public static String getPropertyValue(String key) {
        LOGGER.info("getPropertyValue(" + key + ")");

        String propertyValue = properties.getProperty(key);
//        Properties properties = new Properties();
//
//        try (FileInputStream in = new FileInputStream("src/main/resources/database.properties")) {
//            properties.load(in);
//        } catch (IOException e) {
//            LOGGER.log(Level.SEVERE, "", e);
//        }
        LOGGER.info("getPropertyValue(...) = " + propertyValue);
        return propertyValue;
    }
}
