package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.ReservationRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.ReservationEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.ReservationMapper;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ReservationService {

    private static final Logger LOGGER = Logger.getLogger(ReservationService.class.getName());

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final PropertyRepository propertyRepository;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper, PropertyRepository propertyRepository1) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.propertyRepository = propertyRepository1;
    }

    public Reservation create(Reservation reservation) throws ReservationCreateException {
        LOGGER.info("create(" + reservation + ")");

        try {
            Long propertyId = reservation.getPropertyId();
            Optional<PropertyEntity> readPropertyOptional = propertyRepository.findById(propertyId);
            PropertyEntity propertyEntity = readPropertyOptional.orElseThrow(
                    () -> new ReservationCreateException("Property not found in database for property id: " + propertyId));

            ReservationEntity reservationEntity = reservationMapper.from(reservation);
            reservationEntity.setProperty(propertyEntity);

            ReservationEntity saveReservation = reservationRepository.save(reservationEntity);
            Reservation reservationCreated = reservationMapper.from(saveReservation);

            LOGGER.info("create(...) = " + reservationCreated);
            return reservationCreated;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while saving reservation: " + reservation, e);
            throw new ReservationCreateException("Database access error while saving reservation: " + reservation);
        }
    }

    public Reservation read(Long id) throws ReservationReadException {
        LOGGER.info("read(" + id + ")");

        Optional<ReservationEntity> optionalReservationEntity = reservationRepository.findById(id);
        ReservationEntity reservationEntity = optionalReservationEntity.orElseThrow(() -> {
            LOGGER.log(Level.SEVERE, "Reservation not found for given id: " + id);
            return new ReservationReadException("Reservation not found for given id: " + id);
        });

        Reservation reservation = reservationMapper.from(reservationEntity);

        LOGGER.info("read(...) = " + reservation);
        return reservation;
    }

    public Reservation update(Reservation reservation) throws ReservationUpdateException {
        LOGGER.info("update(" + reservation + ")");

        if (reservation == null) {
            throw new ReservationUpdateException("Model must not be NULL");
        }

        try {
            ReservationEntity reservationEntity = reservationMapper.from(reservation);
            ReservationEntity reservationSaved = reservationRepository.save(reservationEntity);
            Reservation reservationUpdated = reservationMapper.from(reservationSaved);

            LOGGER.info("update(...) = " + reservationUpdated);
            return reservationUpdated;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while updating reservation: " + reservation, e);
            throw new ReservationUpdateException("Database access error while updating reservation: " + reservation);
        }
    }

    public void delete(Long id) throws ReservationDeleteException {
        LOGGER.info("delete(" + id + ")");

        try {
            reservationRepository.deleteById(id);
        } catch(DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while deleting apartment with ID: " + id, e);
            throw new ReservationDeleteException("Database access error while deleting apartment with ID: " + id);
        } catch(IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Id cannot be NULL");
            throw new ReservationDeleteException("Id was NULL");
        }

        LOGGER.info("delete(...) = ");
    }
}
