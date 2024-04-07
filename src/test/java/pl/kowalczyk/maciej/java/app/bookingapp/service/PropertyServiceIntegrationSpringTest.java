package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyServiceIntegrationSpringTest {

    public static final String SERVICE_TEST_READ_WITH_PROPERTY_NAME = "Service_test_read_with_property";

    @Autowired
    private PropertyService propertyService;

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
}