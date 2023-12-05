package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.utils.UniqueId;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.GuestBuilder;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GuestDaoIntegrationTest {

    public static final String GUEST_NAME_MACIEJ = "Maciej";

    @Test
    void read() {
        // given

        GuestDao guestDao = new GuestDao();
        Guest guest = new GuestBuilder()
                .addName(GUEST_NAME_MACIEJ)
                .build();

        // when
        Guest createdGuest = guestDao.create(guest);
        Guest guestRead = guestDao.read(createdGuest.getId());

        // then
        Assertions.assertNotNull(guestRead, "Guest not found");
    }
}