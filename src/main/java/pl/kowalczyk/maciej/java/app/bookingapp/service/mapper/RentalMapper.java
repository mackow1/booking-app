package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.logging.Logger;

@Component
public class RentalMapper {

    private static final Logger LOGGER = Logger.getLogger(RentalMapper.class.getName());

    public Rental fromReservation(Reservation reservation) {
        LOGGER.info("fromReservation(" + reservation + ")");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        Rental mappedRental = modelMapper.map(reservation, Rental.class);

        LOGGER.info("fromReservation(...) = " + mappedRental);
        return mappedRental;
    }
}
