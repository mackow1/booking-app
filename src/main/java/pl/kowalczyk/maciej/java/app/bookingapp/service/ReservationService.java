package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.ReservationRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.ReservationEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.ReservationMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ReservationService {

    private static final Logger LOGGER = Logger.getLogger(ReservationService.class.getName());

    private final PropertyService propertyService;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(PropertyService propertyService, ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.propertyService = propertyService;
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public Reservation create(Reservation reservation) throws ReservationCreateException, PropertyReadException {
        LOGGER.info("create(" + reservation + ")");

        if (reservation == null) {
            throw new ReservationCreateException("Reservation must not be NULL");
        }
        try {
            Long propertyId = reservation.getPropertyId();
            Property readProperty = propertyService.read(propertyId);

            ReservationEntity reservationEntity = reservationMapper.from(reservation);
            ReservationEntity saveReservation = reservationRepository.save(reservationEntity);
            Reservation reservationCreated = reservationMapper.from(saveReservation);

            // dodac mapper i dokończyć implemetnacje
            LOGGER.info("create(...) = " + reservationCreated);
            return reservationCreated;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while saving reservation: " + reservation, e);
            throw new ReservationCreateException("Database access error while saving reservation: " + reservation);
        }
    }
}
