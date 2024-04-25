package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.ReservationRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationEntityTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void create() {
        // given
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setNumberOfPersons(5);
        reservationEntity.setCheckIn("12-12-2020");
        reservationEntity.setCheckOut("15-12-2020");

        // when
        ReservationEntity savedReservation = reservationRepository.save(reservationEntity);

        // then
        Assertions.assertNotNull(savedReservation, "Entity is NULL");
    }

    @Test
    void createWithStatus() {
        // given
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setNumberOfPersons(3);

        // when
        ReservationEntity savedReservationEntity = reservationRepository.save(reservationEntity);

        // then
        Assertions.assertEquals(ReservationStatus.NEW, savedReservationEntity.getStatus(), "Status is not equal NEW");
    }
}
