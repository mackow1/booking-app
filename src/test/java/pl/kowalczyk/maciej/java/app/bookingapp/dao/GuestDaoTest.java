package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

import java.util.List;
import java.util.Random;

class GuestDaoTest {

    public static final String GUEST_NAME_MACIEJ = "Maciej";

    @Test
    void givenGuestDaoAndEmptyGuest_whenCreate_thenCreatedGuestNotNull() {
        // given
        GuestDao guestDao = new GuestDao();
        Guest guest = new Guest();
        Random random = new Random();

        // when
        guest.setId(random.nextLong());
        Guest createdGuest = guestDao.create(guest);

        // then
        Assertions.assertNotNull(createdGuest, "Guest not created");
    }

    @Test
    void givenGuestDaoAndGuestWithData_whenCreate_thenCreatedGuestNotNull() {
        // given
        Random random = new Random();

        GuestDao guestDao = new GuestDao();
        Guest guest = new Guest();
        guest.setId(random.nextLong());
        guest.setName(GUEST_NAME_MACIEJ);

        // when
        Guest createdGuest = guestDao.create(guest);

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
        GuestDao guestDao = new GuestDao();
        int id = 2;

        // when
        Guest guestFound = guestDao.read(id);

        // then
        Assertions.assertNotNull(guestFound, "Guest not found");
    }

    @Test
    void list() {
        // given
        GuestDao guestDao = new GuestDao();
        List<Guest> list;

        // when
        list = guestDao.list();

        // then
        Assertions.assertNotNull(list, "List is null");
    }


    @Test
    void update() {
        // given
        GuestDao guestDao = new GuestDao();
        int id = 2;
        String name = "name";
        Guest guest;

        // when
        guest = guestDao.update(id, name);

        // then
        Assertions.assertNotNull(guest, "Guest not updated");

    }

    @Test
    void delete() {
        // given
        GuestDao guestDao = new GuestDao();
        Guest guest;
        int id = 1;

        // when
        guest = guestDao.delete(1);

        // then
        Assertions.assertNotNull(guest, "Guest not deleted");
    }
}
