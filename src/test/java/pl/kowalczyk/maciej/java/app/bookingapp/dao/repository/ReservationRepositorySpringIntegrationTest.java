package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.ReservationEntity;

@SpringBootTest
class ReservationRepositorySpringIntegrationTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    @Transactional
    void create() {
        // given
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setName("Apartament testowy");

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckIn("12-12-2024");

        // when
        PropertyEntity savedProperty = propertyRepository.save(propertyEntity);
        Long savedPropertyId = savedProperty.getId();

        reservationEntity.setProperty(savedProperty);

        ReservationEntity savedReservation = reservationRepository.save(reservationEntity);
        Long reservationPropertyId = savedReservation.getProperty().getId();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedReservation, "Entity is NULL"),
                () -> Assertions.assertEquals(savedPropertyId, reservationPropertyId, "Ids are not equal")
        );
    }

    /*
SELECT * FROM PROPERTIES as P
LEFT JOIN RESERVATIONS as R
ON P.ID = R.PROPERTY_ID;

SELECT * FROM PROPERTIES;
SELECT * FROM RESERVATIONS ;
     */
}