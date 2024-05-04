package pl.kowalczyk.maciej.java.app.bookingapp.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RentalStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental.RentalDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental.RentalReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.List;

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
        Long propertyCreatedId = propertyCreated.getId();

        Reservation reservation = new Reservation();
        reservation.setCheckIn("12-12-2024");
        reservation.setGuest(guestCreated);
//        reservation.setProperty(propertyCreated);
        reservation.setPropertyId(propertyCreatedId);

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        // when
        Rental rentalFromReservation = rentalService.createFromReservation(id);
        Reservation reservationFromCreatedRental = rentalFromReservation.getReservation();

//        System.out.println("#### ---- " + rentalId);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rentalFromReservation, "Rental is NULL"),
//                () -> Assertions.assertNotNull(rentalFromReservation.getGuest(), "Guest for rental is NULL"),
                () -> Assertions.assertNotNull(rentalFromReservation.getProperty(), "Property is NULL"),
                () -> Assertions.assertNotNull(rentalFromReservation.getReservation(), "Reservation is NULL"),
                () -> Assertions.assertEquals(reservation.getCheckIn(), rentalFromReservation.getCheckIn(), "Check-ins are not equal"),
                () -> Assertions.assertEquals(property.getName(), rentalFromReservation.getProperty().getName(), "Property names are not equal"),
                () -> Assertions.assertEquals(RentalStatus.NEW, rentalFromReservation.getStatus(), "Rental status not equal NEW"),
                () -> Assertions.assertEquals(ReservationStatus.ACCEPTED, reservationFromCreatedRental.getStatus(), "Status is not equal to ACCEPTED")
        );
    }

    @Test
    void list() {
        // given
        Rental rental = new Rental();
        rental.setCheckIn("12-12-2020");
        rental.setCheckOut("16-12-2020");

        rentalService.create(rental);

        // when
        List<Rental> rentalsRead = rentalService.list();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rentalsRead, "Rentals list is NULL"),
                () -> Assertions.assertEquals(1, rentalsRead.size(), "Rental list is not equal 1")
        );
    }

    @Test
    @Transactional
    void read() throws PropertyCreateException, ReservationCreateException, RentalReadException, ReservationReadException {
        // given
        Guest guest = new Guest();
        guest.setName("Michał");
        Guest guestCreated = guestService.create(guest);

        Property property = new Property();
        property.setName("Villa servicowa read test");
        Property propertyCreated = propertyService.create(property);
        Long propertyCreatedId = propertyCreated.getId();

        Reservation reservation = new Reservation();
        reservation.setCheckIn("12-12-2024");
        reservation.setGuest(guestCreated);
//        reservation.setProperty(propertyCreated);
        reservation.setPropertyId(propertyCreatedId);

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        // when
        Rental fromReservation = rentalService.createFromReservation(id);
        Long fromReservationId = fromReservation.getId();

        Rental readRental = rentalService.read(id);
        Long rentalId = readRental.getId();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readRental, "Rental is NULL"),
                () -> Assertions.assertNotNull(fromReservationId, "Id is NULL"),
                () -> Assertions.assertEquals(fromReservationId, rentalId, "Ids are not equal")
        );
    }

    @Test
    @Transactional
    void delete() throws PropertyCreateException, ReservationCreateException, RentalDeleteException, ReservationReadException {
        // given
        Guest guest = new Guest();
        guest.setName("Marcin");
        Guest guestCreated = guestService.create(guest);

        Property property = new Property();
        property.setName("Villa servicowa delete");
        Property propertyCreated = propertyService.create(property);
        Long propertyCreatedId = propertyCreated.getId();

        Reservation reservation = new Reservation();
        reservation.setCheckIn("14-12-2024");
        reservation.setGuest(guestCreated);
//        reservation.setProperty(propertyCreated);
        reservation.setPropertyId(propertyCreatedId);

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        // when
        Rental rentalFromReservation = rentalService.createFromReservation(id);
        Long rentalId = rentalFromReservation.getId();

        Rental deletedRental = rentalService.delete(rentalId);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(deletedRental, "Rental is NULL"),
                () -> Assertions.assertEquals(RentalStatus.CANCELED, deletedRental.getStatus(), "Rental status is not equal CANCELED")
        );
    }
}