package pl.kowalczyk.maciej.java.app.bookingapp.service;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.GuestDao;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.GuestEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

import java.util.logging.Logger;

public class GuestService {

    private static final Logger LOGGER = Logger.getLogger(GuestService.class.getName());

    private GuestDao guestDao;

    public GuestService(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    public Guest create(Guest guest) {
        LOGGER.info("create(" + guest + ")");

        Guest daoGuest = guestDao.create(guest);
        Guest result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
