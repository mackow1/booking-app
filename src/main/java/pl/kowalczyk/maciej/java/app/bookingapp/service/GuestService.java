package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.JdbcGuestDao;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.GuestRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

import java.util.logging.Logger;

@Service
public class GuestService {

    private static final Logger LOGGER = Logger.getLogger(GuestService.class.getName());

    public Guest create(Guest guest) {
        LOGGER.info("create(" + guest + ")");

        Guest result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
