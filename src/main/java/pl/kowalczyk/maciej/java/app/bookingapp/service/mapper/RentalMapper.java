package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public RentalEntity from(Rental rental) {
        LOGGER.info("from(" + rental + ")");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        RentalEntity rentalEntity = modelMapper.map(rental, RentalEntity.class);

        LOGGER.info("from(...) = " + rentalEntity);
        return rentalEntity;
    }

    public Rental from(RentalEntity rentalEntity) {
        LOGGER.info("from(" + rentalEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        Rental rental = modelMapper.map(rentalEntity, Rental.class);

        LOGGER.info("from(...) = " + rental);
        return rental;
    }

    public List<Rental> fromEntities(List<RentalEntity> rentalEntities) {
        LOGGER.info("fromEntities(" + rentalEntities + ")");

        ModelMapper modelMapper = new ModelMapper();
        List<Rental> rentalList = rentalEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + rentalList);
        return rentalList;
    }
}
