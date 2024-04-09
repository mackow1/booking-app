package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.ReservationRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.logging.Logger;

@Service
public class ReservationService {

    private static final Logger LOGGER = Logger.getLogger(ReservationService.class.getName());

    private final PropertyService propertyService;
    private final ReservationRepository reservationRepository;

    public ReservationService(PropertyService propertyService, ReservationRepository reservationRepository) {
        this.propertyService = propertyService;
        this.reservationRepository = reservationRepository;
    }

    public Reservation create(Reservation reservation) throws PropertyReadException {
        LOGGER.info("create(" + reservation + ")");

        if (reservation != null) {
            Long propertyId = reservation.getPropertyId();
            Property readProperty = propertyService.read(propertyId);

            // dodac mapper i dokończyć implemetnacje

//            reservation
        }

        Reservation result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
