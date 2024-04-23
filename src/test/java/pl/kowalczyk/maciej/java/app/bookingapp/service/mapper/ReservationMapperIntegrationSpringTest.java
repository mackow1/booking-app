package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.ReservationRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.ReservationEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationMapperIntegrationSpringTest {

    @Autowired
    private ReservationMapper reservationMapper;

    @Test
    void fromEntities() {
        // given
        List<ReservationEntity> reservationEntities = new ArrayList<>();
        ReservationEntity firstReservationEntity = new ReservationEntity();
        firstReservationEntity.setNumberOfPersons(5);

        ReservationEntity secondReservationEntity = new ReservationEntity();
        secondReservationEntity.setNumberOfPersons(1);

        reservationEntities.add(firstReservationEntity);
        reservationEntities.add(secondReservationEntity);

        int entitiesListSize = reservationEntities.size();

        // when

        List<Reservation> reservations = reservationMapper.fromEntities(reservationEntities);
        int reservationsListSize = reservations.size();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservations, "List is NULL"),
                () -> Assertions.assertEquals(entitiesListSize, reservationsListSize, "List sizes are not equal")
        );
    }
}
