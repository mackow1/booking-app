package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RentalRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.RentalMapper;

import java.util.List;
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
        Rental rental = rentalMapper.fromReservation(readReservation);

        LOGGER.info("createFromReservation(...) = " + rental);
        return rental;
    }
}
