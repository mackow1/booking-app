package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.util.Random;
import java.util.logging.Logger;

public class UniqueId {

    private static final Logger LOGGER = Logger.getLogger(UniqueId.class.getName());

    public static Long generate() {
        LOGGER.info("generate()");
        long randomNumber = new Random().nextLong();
        LOGGER.info("generate(...) = " + randomNumber);
        return randomNumber;
    }
}
