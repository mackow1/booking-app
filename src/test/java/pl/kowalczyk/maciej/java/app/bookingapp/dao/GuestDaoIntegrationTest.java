package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GuestDaoIntegrationTest {

    @Test
    void read() {
        // given
        Random random = new Random();

        GuestDao guestDao = new GuestDao();
        Guest guest = new Guest();
        int id = random.nextInt();

        // when
        guestDao.create(guest);
        Guest guestRead = guestDao.read(id);

        // then
        Assertions.assertNotNull(guestRead, "Guest not found");
    }
}