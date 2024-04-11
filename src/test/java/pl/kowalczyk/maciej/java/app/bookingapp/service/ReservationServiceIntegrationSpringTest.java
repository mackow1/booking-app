package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceIntegrationSpringTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    void givenReservationWhenReadThenReservationFound() throws PropertyReadException, ReservationCreateException, ReservationReadException {
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
}