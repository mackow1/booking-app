package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

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
}