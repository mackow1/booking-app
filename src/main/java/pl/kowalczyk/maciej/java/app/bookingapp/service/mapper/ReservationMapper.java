package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.ReservationEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.logging.Logger;

@Component
public class ReservationMapper {

    private static final Logger LOGGER = Logger.getLogger(ReservationMapper.class.getName());

    public ReservationEntity from(Reservation reservation) {
        LOGGER.info("from(" + reservation + ")");

        ModelMapper modelMapper = new ModelMapper();
        ReservationEntity reservationEntity = modelMapper.map(reservation, ReservationEntity.class);

        LOGGER.info("from(...) = " + reservationEntity);
        return reservationEntity;
    }

    public Reservation from(ReservationEntity reservationEntity) {
        LOGGER.info("from(" + reservationEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        Reservation reservation = modelMapper.map(reservationEntity, Reservation.class);

        LOGGER.info("from(...) = " + reservation);
        return reservation;
    }
}
