package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.utils.UniqueId;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GuestDaoIntegrationTest {

    public static final String GUEST_NAME_MACIEJ = "Maciej";

    @Test
    void read() {
        // given
        long id = UniqueId.generate();

        GuestDao guestDao = new GuestDao();
        Guest guest = new Guest();

        // when
        guestDao.create(guest);
        Guest guestRead = guestDao.read(id);

        // then
        Assertions.assertNotNull(guestRead, "Guest not found");
    }
}