package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.util.Random;

public class UniqueId {

    public static Long generate() {
        return new Random().nextLong();
    }
}
