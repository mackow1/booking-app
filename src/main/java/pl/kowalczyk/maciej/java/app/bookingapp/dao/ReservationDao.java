package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.logging.Logger;

public class ReservationDao {

    private static final Logger LOGGER = Logger.getLogger(ReservationDao.class.getName());

    public Reservation create(Reservation guest) {
        LOGGER.info("create(" + guest + ")");
        Reservation createdReservation = null;
        LOGGER.info("create(...) = " + createdReservation);
        return createdReservation;
    }

    public Reservation read(int id) {
        LOGGER.info("read(" + id + ")");
        Reservation reservationFound = null;
        LOGGER.info("read(...) = " + reservationFound);
        return reservationFound;
    }
}
