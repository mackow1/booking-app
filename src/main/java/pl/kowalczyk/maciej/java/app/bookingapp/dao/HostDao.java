package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;

import java.util.logging.Logger;

public class HostDao {

    private static final Logger LOGGER = Logger.getLogger(HostDao.class.getName());

    public Host create(Host host) {
        LOGGER.info("create(" + host + ")");
        Host hostCreated = null;
        LOGGER.info("create(...) = " + hostCreated);
        return hostCreated;
    }

    public Host read(int id) {
        LOGGER.info("read(" + id + ")");
        Host hostFound = null;
        LOGGER.info("read(...)" + hostFound);
        return hostFound;
    }
}
