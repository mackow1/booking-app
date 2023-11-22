package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

class PropertyDaoTest {

    @Test
    void create() {
        // given
        PropertyDao propertyDao = new PropertyDao();
        Property property = new Property();

        // when
        Property createdProperty = propertyDao.create(property);

        // then
        Assertions.assertNotNull(createdProperty, "Property not created");
    }

    @Test
    void read() {
        // given
        PropertyDao propertyDao = new PropertyDao();
        int id = 0;

        // when
        Property propertyFound = propertyDao.read(id);

        // then
        Assertions.assertNotNull(propertyFound, "Property not found");
    }
}