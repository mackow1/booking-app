package pl.kowalczyk.maciej.java.app.bookingapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class RentalTest {

    @Test
    void checkRentalIdCreatedByTheMethod() {

        Rental reservation = new Rental(new Guest(), new Reservation("12.12.2023", "15.12.2023", 4));

        LocalDateTime localDate = LocalDateTime.now();

        int day = localDate.getDayOfMonth();
        int hour = localDate.getHour();
        int minute = localDate.getMinute();

        Assertions.assertEquals("" + minute + hour + day, reservation.getId());
    }

    @Test
    void createID() {
        // given
        Guest guest = new Guest();
        String checkIn = "";
        String checkOut = "";
        int numberOfPersons = 0;
        Reservation reservation = new Reservation(checkIn, checkOut, numberOfPersons);

        Rental rental = new Rental(guest, reservation);

        // when
        String firstId = rental.createID();
        String secondId = rental.createID();

        // then
        Assertions.assertNotEquals(firstId, secondId, "Generated IDs are equals");
    }
}
