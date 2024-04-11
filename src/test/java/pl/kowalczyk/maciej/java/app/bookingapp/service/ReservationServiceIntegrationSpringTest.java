package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceIntegrationSpringTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    void givenReservationWhenReadThenReservationFound() throws ReservationCreateException, ReservationReadException {
        // given
        Reservation reservation = new Reservation();
        reservation.setCheckIn("13-10-2020");
        reservation.setCheckOut("15-10-2020");
        reservation.setNumberOfPersons(5);

        Reservation reservationCreated = reservationService.create(reservation);

        Long id = reservationCreated.getId();

        // when
        Reservation reservationRead = reservationService.read(id);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservationRead, "Reservation is NULL"),
                () -> Assertions.assertEquals(5, reservationCreated.getNumberOfPersons(), "Number of persons are equal")
        );
    }

    @Test
    void givenReservationWhenUpdateThenReservationUpdated() throws ReservationCreateException, ReservationUpdateException, ReservationReadException {
        // given
        Reservation reservation = new Reservation();
        reservation.setCheckIn("10-10-2022");
        reservation.setCheckOut("15-10-2022");

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        Reservation reservationUpdate = new Reservation();
        reservationUpdate.setId(id);
        reservationUpdate.setCheckIn("11-10-2022");
        reservationUpdate.setCheckOut("16-10-2022");

        // when
        Reservation reservationUpdated = reservationService.update(reservationUpdate);
        Reservation reservationRead = reservationService.read(id);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservationUpdated, "Reservation is NULL"),
                () -> Assertions.assertEquals("11-10-2022", reservationRead.getCheckIn(), "Dates are not equal"),
                () -> Assertions.assertEquals("16-10-2022", reservationRead.getCheckOut(), "Dates are not equal")
        );

    }

    @Test
    void givenIdWhenDeleteThenReservationRemoved() throws ReservationCreateException, ReservationDeleteException {
        // given
        Reservation reservation = new Reservation();
        reservation.setCheckIn("20-10-2022");
        reservation.setCheckOut("23-10-2022");

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        // when
        reservationService.delete(id);

        // then
        Assertions.assertThrows(ReservationReadException.class, () -> reservationService.read(id));
    }
}