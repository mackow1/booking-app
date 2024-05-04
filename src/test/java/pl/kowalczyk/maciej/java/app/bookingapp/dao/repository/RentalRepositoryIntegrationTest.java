package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental.RentalReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentalRepositoryIntegrationTest {

    private RentalRepository rentalRepository;

    @Test
    void deleteById() {
        // given
        RentalEntity rental = new RentalEntity();
        rental.setCheckIn("12-12-2012");
        rental.setCheckOut("18-12-2012");

        RentalEntity savedRentalEntity = rentalRepository.save(rental);
        Long id = savedRentalEntity.getId();

        // when
        rentalRepository.deleteById(id);

        // then
//        Assertions.assertThrows(RentalReadException.class, () -> )
    }
}