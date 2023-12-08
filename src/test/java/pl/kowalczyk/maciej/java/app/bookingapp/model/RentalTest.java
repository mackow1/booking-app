package pl.kowalczyk.maciej.java.app.bookingapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RentalTest {

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
