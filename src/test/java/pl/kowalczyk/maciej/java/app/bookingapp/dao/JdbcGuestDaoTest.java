package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.utils.UniqueId;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.GuestBuilder;

import java.util.List;
import java.util.Random;

class JdbcGuestDaoTest {

    public static final String GUEST_NAME_MACIEJ = "Maciej";

    @Test
    void givenGuestDaoAndEmptyGuest_whenCreate_thenCreatedGuestNotNull() {
        // given
        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        Guest guest = new Guest();
        Random random = new Random();

        // when
        guest.setId(random.nextLong());
        Guest createdGuest = jdbcGuestDao.create(guest);

        // then
        Assertions.assertNotNull(createdGuest, "Guest not created");
    }

    @Test
    void givenGuestDaoAndGuestWithData_whenCreate_thenCreatedGuestNotNull() {
        // given
        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        Guest guest = new GuestBuilder()
                .addId(UniqueId.generate())
                .addName(GUEST_NAME_MACIEJ)
                .build();

        // when
        Guest createdGuest = jdbcGuestDao.create(guest);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdGuest, "Guest not created"),
                () -> Assertions.assertNotNull(createdGuest.getId(), "Id not created"),
                () -> Assertions.assertEquals(GUEST_NAME_MACIEJ, createdGuest.getName(), "Guest name does not match " + GUEST_NAME_MACIEJ)
        );
    }

    @Test
    void read() {
        // given
        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        int id = 2;

        // when
        Guest guestFound = jdbcGuestDao.read(id);

        // then
        Assertions.assertNotNull(guestFound, "Guest not found");
    }

    @Test
    void list() {
        // given
        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        List<Guest> list;

        // when
        list = jdbcGuestDao.list();

        // then
        Assertions.assertNotNull(list, "List is null");
    }


    @Test
    void update() {
        // given
        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        int id = 2;
        String name = "name";
        Guest guest;

        // when
        guest = jdbcGuestDao.update(id, name);

        // then
        Assertions.assertNotNull(guest, "Guest not updated");

    }

    @Test
    void delete() {
        // given
        JdbcGuestDao jdbcGuestDao = new JdbcGuestDao();
        Guest guest;
        int id = 1;

        // when
        guest = jdbcGuestDao.delete(1);

        // then
        Assertions.assertNotNull(guest, "Guest not deleted");
    }
}
