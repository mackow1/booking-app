package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.ArrayList;
import java.util.List;

class RentalMapperTest {

    @Test
    void fromReservation() {
        // given
        RentalMapper rentalMapper = new RentalMapper();

        Guest guest = new Guest();
        guest.setName("Marcin");

        Property property = new Property();
        property.setName("Villa testowa");
        property.setId(12L);

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setCheckIn("10-10-2024");
        reservation.setGuest(guest);
        reservation.setProperty(property);

        // when
        Rental rentalMapped = rentalMapper.fromReservation(reservation);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rentalMapped)
        );
    }

    @Test
    void fromRentalToRentalEntity() {
        // given
        RentalMapper rentalMapper = new RentalMapper();

        Rental rental = new Rental();
        rental.setCheckIn("12-12-2020");
        rental.setCheckOut("16-12-2020");

        // when
        RentalEntity rentalEntity = rentalMapper.from(rental);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rentalEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(rental.getCheckIn(), rentalEntity.getCheckIn(), "Check-ins are not equal")
        );
    }

    @Test
    void fromRentalEntityToRental() {
        // given
        RentalMapper rentalMapper = new RentalMapper();

        RentalEntity rentalEntity = new RentalEntity();
        rentalEntity.setCheckIn("12-12-2020");
        rentalEntity.setCheckOut("16-12-2020");

        // when
        Rental rental = rentalMapper.from(rentalEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rental, "Entity is NULL"),
                () -> Assertions.assertEquals(rentalEntity.getCheckIn(), rental.getCheckIn(), "Check-ins are not equal")
        );
    }

    @Test
    void fromEntities() {
        // given
        RentalMapper rentalMapper = new RentalMapper();

        List<RentalEntity> rentalEntities = new ArrayList<>();
        RentalEntity rentalEntity = new RentalEntity();
        rentalEntity.setCheckIn("12-12-2020");
        rentalEntity.setCheckOut("16-12-2020");

        rentalEntities.add(rentalEntity);

        int entitiesSize = rentalEntities.size();

        // when
        List<Rental> rentals = rentalMapper.fromEntities(rentalEntities);
        int rentalSize = rentals.size();
        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(rentals, "List is NULL"),
                () -> Assertions.assertEquals(entitiesSize, rentalSize, "List sizes are not equal")
        );
    }
}