package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RentalStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental.RentalDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental.RentalReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RentalRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.RentalMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RentalService {

    private static final Logger LOGGER = Logger.getLogger(RentalService.class.getName());

    private final RentalRepository rentalRepository;
    private final ReservationService reservationService;
    private final RentalMapper rentalMapper;

    public RentalService(RentalRepository rentalRepository, ReservationService reservationService, RentalMapper rentalMapper) {
        this.rentalRepository = rentalRepository;
        this.reservationService = reservationService;
        this.rentalMapper = rentalMapper;
    }

    public List<Rental> list() {
        LOGGER.info("list()");

        List<RentalEntity> rentalEntities = rentalRepository.findAll();
        List<Rental> rentals = rentalMapper.fromEntities(rentalEntities);

        LOGGER.info("list(...) = " + rentals);
        return rentals;
    }

    public Rental create(Rental rental) {
        LOGGER.info("create(" + rental + ")");

        RentalEntity rentalEntity = rentalMapper.from(rental);
        RentalEntity savedRentalEntity = rentalRepository.save(rentalEntity);
        Rental rentalSaved = rentalMapper.from(savedRentalEntity);

        LOGGER.info("create(...) = " + rentalSaved);
        return rentalSaved;
    }

    public Rental createFromReservation(Long id) throws ReservationReadException {
        LOGGER.info("createFromReservation(" + id + ")");

        Reservation readReservation = reservationService.read(id);

        readReservation.setStatus(ReservationStatus.ACCEPTED);

        Rental rental = rentalMapper.fromReservation(readReservation);

        RentalEntity rentalEntity = rentalMapper.from(rental);
        RentalEntity savedRentalEntity = rentalRepository.save(rentalEntity);
        Rental savedRental = rentalMapper.from(savedRentalEntity);

        LOGGER.info("createFromReservation(...) = " + savedRental);
        return savedRental;
    }

    public Rental read(Long id) throws RentalReadException {
        LOGGER.info("read(" + id + ")");

        Optional<RentalEntity> foundRental = rentalRepository.findById(id);
        RentalEntity rentalEntity = foundRental.orElseThrow(() -> new RentalReadException("Rental not found for given id: " + id));

        try {
            Rental rental = rentalMapper.from(rentalEntity);
            LOGGER.info("read(...) = " + rental);
            return rental;
        }catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Data access exception while trying to find rental for id: " + id, e);
            throw new RentalReadException("Data access exception while trying to find rental for id: " + id);
        }
    }

    public Rental delete(Long id) throws RentalDeleteException {
        LOGGER.info("delete(" + id + ")");

        Optional<RentalEntity> rentalEntityOptional = rentalRepository.findById(id);
        RentalEntity rentalEntity = rentalEntityOptional.orElseThrow(() -> new RentalDeleteException("Rental not found for given id: " + id));

        rentalEntity.setStatus(RentalStatus.CANCELED);

        try {
            RentalEntity savedRentalEntity = rentalRepository.save(rentalEntity);
            Rental rental = rentalMapper.from(savedRentalEntity);

            LOGGER.info("delete(...) = " + rental);
            return rental;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Data access exception while deleting rental with id: " + id, e);
            throw new RentalDeleteException("Data access exception while deleting rental with id: " + id);
        }
    }
}
