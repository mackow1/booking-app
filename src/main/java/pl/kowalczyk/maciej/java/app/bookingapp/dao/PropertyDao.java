package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import java.util.logging.Logger;

public class PropertyDao {

    private static final Logger LOGGER = Logger.getLogger(PropertyDao.class.getName());

    public Property create(Property property) {
        LOGGER.info("create(" + property + ")");
        Property propertyCreated = null;
        LOGGER.info("create(...) = " + propertyCreated);
        return propertyCreated;
    }

    public Property read(int id) {
        LOGGER.info("read(" + id + ")");
        Property propertyFound = null;
        LOGGER.info("read(...) = " + propertyFound);
        return propertyFound;
    }
}
