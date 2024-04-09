package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyServiceIntegrationSpringTest {

    public static final String SERVICE_TEST_READ_WITH_PROPERTY_NAME = "Service_test_read_with_property";
    public static final String SERVICE_TEST_UPDATE_WITH_PROPERTY_NAME = "Service_test_update_with_property";

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void givenIdOfAnExistingPropertyWhenReadReturnProperProperty() throws PropertyCreateException, PropertyReadException {
        // given
        Property property = new Property();
        property.setName(SERVICE_TEST_READ_WITH_PROPERTY_NAME);

        Property propertyCreated = propertyService.create(property);
        Long id = propertyCreated.getId();

        // when
        Property readProperty = propertyService.read(id);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readProperty, "Property is NULL"),
                () -> Assertions.assertEquals(id, readProperty.getId(), "IDs are not equal"),
                () -> Assertions.assertEquals(SERVICE_TEST_READ_WITH_PROPERTY_NAME, readProperty.getName(), "Names are not equal")
        );
    }

    @Test
    void givenPropertyWhenUpdateThenReturnUpdatedProperty() throws PropertyCreateException, PropertyUpdateException {
        // given
        Property property = new Property();
        property.setName("Not updated villa");

        Property propertyCreated = propertyService.create(property);
        Long id = propertyCreated.getId();

        Property propertyToUpdate = new Property();
        propertyToUpdate.setId(id);
        propertyToUpdate.setName(SERVICE_TEST_UPDATE_WITH_PROPERTY_NAME);

        // when
        Property updatedProperty = propertyService.update(propertyToUpdate);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updatedProperty, "Property is NULL"),
                () -> Assertions.assertEquals(SERVICE_TEST_UPDATE_WITH_PROPERTY_NAME, updatedProperty.getName(), "Names are not equal")
        );
    }

    @Test
    void givenIdWhenDeleteObjectProperlyDeleted() throws PropertyCreateException, PropertyDeleteException {
        // given
        Property property = new Property();
        property.setName("Villa removal");

        Property propertyCreated = propertyService.create(property);
        Long id = propertyCreated.getId();

        // when
        propertyService.delete(id);

        // then
        Assertions.assertThrows(PropertyReadException.class, () -> propertyService.read(id));
    }
}