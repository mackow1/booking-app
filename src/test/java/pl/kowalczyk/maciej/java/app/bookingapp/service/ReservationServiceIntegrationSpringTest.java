package pl.kowalczyk.maciej.java.app.bookingapp.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.GuestEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceIntegrationSpringTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PropertyService propertyService;

    @Test
    @Transactional
    void givenPropertyAndReservationWhenCreateThenNewReservationCreated() throws PropertyCreateException, ReservationCreateException {
        // given
        Property property = new Property();
        property.setName("Villa Testowa");

        Reservation reservation = new Reservation();
        reservation.setCheckIn("13-10-2020");
        reservation.setCheckOut("15-10-2020");
        reservation.setNumberOfPersons(5);

        // when
        Property propertyCreated = propertyService.create(property);
        Long propertyCreatedId = propertyCreated.getId();
        reservation.setPropertyId(propertyCreatedId);

        Reservation reservationCreated = reservationService.create(reservation);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservationCreated, "Reservation is NULL"),
                () -> Assertions.assertEquals(propertyCreatedId, reservationCreated.getPropertyId(), "Ids are different")
        );
    }

    @Test
    @Transactional
    void givenReservationAndGuestWhenCreateThenReservationCreated() throws ReservationCreateException, PropertyCreateException {
        // given
        Property property = new Property();
        property.setName("Villa Testowa");
        Property propertyCreated = propertyService.create(property);
        Long propertyCreatedId = propertyCreated.getId();

        Guest guest = new Guest();
        guest.setName("Gosc testowy");

        Reservation reservation = new Reservation();
        reservation.setCheckIn("13-10-2020");
        reservation.setCheckOut("15-10-2020");
        reservation.setNumberOfPersons(5);
        reservation.setGuest(guest);
        reservation.setPropertyId(propertyCreatedId);

        // when
        Reservation reservationCreated = reservationService.create(reservation);
        Guest guestFromReservation = reservation.getGuest();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(guestFromReservation, "Guest is NULL"),
                () -> Assertions.assertEquals(guest.getName(), guestFromReservation.getName(), "Names of guest are not equal")
        );
    }

    @Test
    void givenReservationWhenReadThenReservationFound() throws ReservationCreateException, ReservationReadException {
        // given
        Reservation reservation = new Reservation();
        reservation.setCheckIn("13-10-2020");
        reservation.setCheckOut("15-10-2020");
        reservation.setNumberOfPersons(5);

        // when
        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();
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
    @Transactional
    void givenIdWhenDeleteThenReservationCanceled() throws ReservationCreateException, ReservationDeleteException, ReservationReadException, PropertyCreateException {
        // given
        Property property = new Property();
        property.setName("Villa Testowa Canceled");

        Reservation reservation = new Reservation();
        reservation.setCheckIn("20-10-2022");
        reservation.setCheckOut("23-10-2022");

        Property propertyCreated = propertyService.create(property);
        Long propertyCreatedId = propertyCreated.getId();
        reservation.setPropertyId(propertyCreatedId);

        Reservation reservationCreated = reservationService.create(reservation);
        Long id = reservationCreated.getId();

        // when
        reservationService.delete(id);
        Reservation readDeletedReservation = reservationService.read(id);

        // then
        Assertions.assertEquals(ReservationStatus.CANCELED, readDeletedReservation.getStatus(), "Status of the reservation is not equal to CANCELED");
    }
}