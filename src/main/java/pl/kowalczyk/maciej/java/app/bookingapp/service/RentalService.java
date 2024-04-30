package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RentalRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.RentalMapper;

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

    public Rental create(Rental rental) {
        LOGGER.info("create(" + rental + ")");

        Rental result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }

    public Rental createFromReservation(Long id) throws ReservationReadException {
        LOGGER.info("createFromReservation(" + id + ")");

        Reservation readReservation = reservationService.read(id);
        Rental rental = rentalMapper.fromReservation(readReservation);

        LOGGER.info("createFromReservation(...) = " + rental);
        return rental;
    }
}
