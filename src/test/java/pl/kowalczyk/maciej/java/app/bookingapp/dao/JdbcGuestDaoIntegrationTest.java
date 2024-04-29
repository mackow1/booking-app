package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.GuestBuilder;

class JdbcGuestDaoIntegrationTest {

    public static final String GUEST_NAME_MACIEJ = "Maciej";

    @Test
    void read() {
        // given

        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        Guest guest = new GuestBuilder()
                .addName(GUEST_NAME_MACIEJ)
                .build();

        // when
        Guest createdGuest = jdbcGuestDao.create(guest);
        Guest guestRead = jdbcGuestDao.read(createdGuest.getId());

        // then
        Assertions.assertNotNull(guestRead, "Guest not found");
    }
}