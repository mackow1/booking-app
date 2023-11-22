package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

class ReservationDaoTest {

    @Test
    void create() {
        // given
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = new Reservation("", "", 0);

        // when
        Reservation createdReservation = reservationDao.create(reservation);

        // then
        Assertions.assertNotNull(createdReservation, "Reservation not created");
    }

    @Test
    void read() {
        // given
        ReservationDao reservationDao = new ReservationDao();
        int id = 0;

        // when
        Reservation reservationFound = reservationDao.read(id);

        // then
        Assertions.assertNotNull(reservationFound, "Reservation not found");
    }
}