package pl.kowalczyk.maciej.java.app.bookingapp.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentalServiceIntegrationTest {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private GuestService guestService;

    @Test
    @Transactional
    void createFromReservation() throws ReservationReadException, ReservationCreateException, PropertyCreateException {
        // given
        Guest guest = new Guest();
        guest.setName("Michał");
        Guest guestCreated = guestService.create(guest);

        Property property = new Property();
        property.setName("Villa servicowa");
        Property propertyCreated = propertyService.create(property);

        Reservation reservation = new Reservation();
        reservation.setCheckIn("12-12-2024");
        reservation.setGuest(guestCreated);
        reservation.setProperty(propertyCreated);

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        // when
        Rental rentalFromReservation = rentalService.createFromReservation(id);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rentalFromReservation, "Rental is NULL"),
                () -> Assertions.assertNotNull(rentalFromReservation.getGuest(), "Guest for rental is NULL"),
                () -> Assertions.assertNotNull(rentalFromReservation.getProperty(), "Property is NULL"),
                () -> Assertions.assertNotNull(rentalFromReservation.getReservation(), "Reservation is NULL"),
                () -> Assertions.assertEquals(reservation.getCheckIn(), rentalFromReservation.getCheckIn(), "Check-ins are not equal"),
                () -> Assertions.assertEquals(property.getName(), rentalFromReservation.getProperty().getName(), "Property names are not equal")
        );
    }
}