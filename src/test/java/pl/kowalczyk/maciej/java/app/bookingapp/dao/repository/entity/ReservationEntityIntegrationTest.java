package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.ReservationRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationEntityIntegrationTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void ThenChangeStatus() {
        // given
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setNumberOfPersons(10);

        // when
        ReservationEntity saved = reservationRepository.save(reservationEntity);

        saved.setStatus(ReservationStatus.CANCELED);

        ReservationEntity savedWithNewStatus = reservationRepository.save(saved);

        // then
        Assertions.assertEquals(ReservationStatus.CANCELED, savedWithNewStatus.getStatus(), "Status is not equal CANCELED");
    }

}
