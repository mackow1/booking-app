package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;

import java.util.logging.Logger;

public class RentalDao {

    private static final Logger LOGGER = Logger.getLogger(RentalDao.class.getName());

    public Rental create(Rental rental) {
        LOGGER.info("create(" + rental + ")");
        Rental rentalCreated = null;
        LOGGER.info("create(...) = " + rentalCreated);
        return rentalCreated;
    }

    public Rental read(int id) {
        LOGGER.info("read(" + id + ")");
        Rental rentalFound = null;
        LOGGER.info("read(...) = " + rentalFound);
        return rentalFound;
    }
}
