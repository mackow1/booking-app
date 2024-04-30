package pl.kowalczyk.maciej.java.app.bookingapp.service;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.JdbcGuestDao;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

import java.util.logging.Logger;

public class GuestService {

    private static final Logger LOGGER = Logger.getLogger(GuestService.class.getName());

    private JdbcGuestDao jdbcGuestDao;

    public GuestService(JdbcGuestDao jdbcGuestDao) {
        this.jdbcGuestDao = jdbcGuestDao;
    }

    public Guest create(Guest guest) {
        LOGGER.info("create(" + guest + ")");

        Guest daoGuest = jdbcGuestDao.create(guest);
        Guest result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
