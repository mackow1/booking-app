package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

class RentalDaoTest {

    @Test
    void create() {
        // given
        Guest guest = new Guest();
        Reservation reservation = new Reservation("", "", 0);

        RentalDao rentalDao = new RentalDao();
        Rental rental = new Rental();

        // when
        Rental createdRental = rentalDao.create(rental);

        // then
        Assertions.assertNotNull(createdRental, "Rental not created");
    }

    @Test
    void read() {
        // given
        RentalDao rentalDao = new RentalDao();
        int id = 0;

        // when
        Rental rentalFound = rentalDao.read(id);

        // then
        Assertions.assertNotNull(rentalFound, "Rental not found");
    }
}