package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentalRepositoryTest {

    @Autowired
    private RentalRepository rentalRepository;

    @Test
    void create() {
        // given
        RentalEntity rental = new RentalEntity();
        rental.setCheckIn("12-12-2012");
        rental.setCheckOut("18-12-2012");

        // when
        RentalEntity savedRentalEntity = rentalRepository.save(rental);

        // then
        Assertions.assertNotNull(savedRentalEntity, "Entity is NULL");
    }
}