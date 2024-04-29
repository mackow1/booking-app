package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentalServiceTest {

    @Autowired
    private RentalService rentalService;

    @Test
    void create() {
        // given
        Rental rental = new Rental();

        // when
        Rental rentalCreated = rentalService.create(rental);

        // then
        Assertions.assertNotNull(rentalCreated, "Rental is NULL");
    }

}