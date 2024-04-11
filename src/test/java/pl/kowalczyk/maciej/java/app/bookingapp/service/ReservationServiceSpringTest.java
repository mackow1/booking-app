package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceSpringTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    void givenReservationModelWhenCreateThenReservationReturned() throws PropertyReadException, ReservationCreateException {
        // given
        Reservation reservation = new Reservation();
        reservation.setCheckIn("12-12-2020");
        reservation.setCheckOut("16-12-2020");

        // when
        Reservation reservationCreated = reservationService.create(reservation);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservationCreated, "Reservation is NULL"),
                () -> Assertions.assertEquals("12-12-2020", reservationCreated.getCheckIn(), "Property id's are different")
        );
    }

    @Test
    void givenNullWhenCreateThenExceptionIsThrown() {
        // given

        // when
        // then
        Assertions.assertThrows(ReservationCreateException.class, () -> reservationService.create(null));
    }
}