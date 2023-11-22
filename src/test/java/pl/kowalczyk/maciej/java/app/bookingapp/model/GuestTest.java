package pl.kowalczyk.maciej.java.app.bookingapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void checkIfTheMethodMakeReservationCreatedNewReservationSuccessfully() {
        Guest guest = new Guest("Maciej Kowalczyk", "maciej.kowalczyk@gmail.com", "123-456-789", new Address(), new ArrayList<>());

        int initialListOfReservationsSize = guest.getReservations().size();
        guest.makeReservation("12-12-2023", "15-12-2023", 4);
//        guest.makeReservation("12-12-2023", "15-12-2023",4);
        int listOfReservationSizeAfterMakingReservation = guest.getReservations().size();
        int result = listOfReservationSizeAfterMakingReservation - initialListOfReservationsSize;

        Assertions.assertEquals(1, result);
    }

    @Test
    void makeReservation() {
        // given - tworzenie obiektów klasy testowanej oraz parametrów metody testowanej
        Guest guest = new Guest();
        String checkIn = "";
        String checkOut = "";
        int numberOfPersons = 0;

        // when - wywołanie metody testowanej
        Reservation reservation = guest.makeReservation(checkIn, checkOut, numberOfPersons);

        // then - sprawdzenie poprawności wartości zwracanej z metody testowanej
        Assertions.assertNotNull(reservation, "reservation is null");
    }

    @Test
    void makeReservationWithSize() {
        // given
        String firstCheckIn = "2023-11-11";
        String firstCheckOut = "2023-11-13";
        int firstNumberOfPersons = 0;
        Reservation firstReservation = new Reservation(firstCheckIn, firstCheckOut, firstNumberOfPersons);

        String checkIn = "2023-11-12";
        String checkOut = "2023-11-14";
        int numberOfPersons = 0;
        Reservation reservation = new Reservation(checkIn, checkOut, numberOfPersons);

        Guest guest = new Guest();

        // when
        Reservation createdFirstReservation = guest.makeReservation(firstCheckIn, firstCheckOut, firstNumberOfPersons);
        Reservation createdReservation = guest.makeReservation(checkIn, checkOut, numberOfPersons);
//        System.out.println("createdFirstReservation: " + createdFirstReservation);
//        System.out.println("createdReservation: " + createdReservation);

        // then

    }
}
