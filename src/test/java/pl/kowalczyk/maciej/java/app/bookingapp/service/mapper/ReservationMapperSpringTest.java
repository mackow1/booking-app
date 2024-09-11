package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.ReservationEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationMapperSpringTest {

    public static final String CHECK_IN_DATE = "12-12-2020";
    public static final String CHECK_OUT_DATE = "15-12-2020";

    @Autowired
    private ReservationMapper reservationMapper;

    @Test
    void givenReservationModelWhenFromThenReservationEntityReturned() {
        // given
        Reservation reservation = new Reservation();
        reservation.setCheckIn(CHECK_IN_DATE);
        reservation.setCheckOut(CHECK_OUT_DATE);

        // when
        ReservationEntity reservationEntity = reservationMapper.from(reservation);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservationEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(CHECK_IN_DATE, reservationEntity.getCheckIn(), "Dates are not equal")
        );
    }

    @Test
    void givenReservationEntityWhenFromThenReservationModelReturned() {
        // given
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckIn(CHECK_IN_DATE);
        reservationEntity.setCheckOut(CHECK_OUT_DATE);
        reservationEntity.setStatus(ReservationStatus.NEW);

        // when
        Reservation reservation = reservationMapper.from(reservationEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(reservation, "Model is NULL"),
                () -> Assertions.assertEquals(CHECK_IN_DATE, reservation.getCheckIn(), "Dates are not equal")
        );
    }
}