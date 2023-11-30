package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.util.logging.Logger;

public class DatabaseCredentials {

    private static final Logger LOGGER = Logger.getLogger(DatabaseCredentials.class.getName());
    private String filePath = "src/main/resources/database.properties";

    public static String getUrl() {
        LOGGER.info("getUrl()");
        String url = "";
        LOGGER.info("getUrl(...) = " + url);
        return url;
    }
}
