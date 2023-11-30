package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseCredentials {

    private static final Logger LOGGER = Logger.getLogger(DatabaseCredentials.class.getName());
    private static final File file = new File("src/main/resources/database.properties");


    public static String getUrl() {
        LOGGER.info("getUrl()");
        String url = "";
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(file)) {
            properties.load(in);
            url = properties.getProperty("url");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
        LOGGER.info("getUrl(...) = " + url);
        return url;
    }

    public static String getUser() {
        LOGGER.info("getUser()");
        String user = null;
        Properties properties = new Properties();

        try (FileInputStream in = new FileInputStream(file)) {
            properties.load(in);
            user = properties.getProperty("user");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        LOGGER.info("getUser(...) = " + user);
        return user;
    }
}
