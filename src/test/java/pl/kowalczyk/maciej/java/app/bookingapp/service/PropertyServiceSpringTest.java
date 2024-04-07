package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import java.util.List;

@SpringBootTest
class PropertyServiceSpringTest {

    public static final String SERVICE_TEST_CREATE_WITH_PROPERTY_NAME = "Service_test_create_with_property";
    @Autowired
    private PropertyService propertyService;

    @Test
    void list() {
        // given

        // when
        List<Property> propertyEntities = propertyService.list();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(propertyEntities, "List is NULL")
//                () -> Assertions.assertEquals(1, propertyEntities.size(), "List length is not equal 1")
        );
    }

    @Test
    void givenNullWhenCreateThenMethodThrowsException() throws PropertyCreateException {
        // given
        Property property = null;

        // when
        // then
        Assertions.assertThrows(PropertyCreateException.class, () -> {
            propertyService.create(property);
        });
    }

    @Test
    void givenPropertyModelWhenCreateThenModelCreatedProperly() throws PropertyCreateException {
        // given
        Property property = new Property();
        property.setName(SERVICE_TEST_CREATE_WITH_PROPERTY_NAME);

        // when
        Property propertyCreated = propertyService.create(property);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(propertyCreated, "Model is NULL"),
                () -> Assertions.assertEquals(SERVICE_TEST_CREATE_WITH_PROPERTY_NAME, propertyCreated.getName(), "Names are not equal")
        );
    }

    @Test
    void givenNonExistingIdWhenReadThenExceptionShouldBeThrown() {
        // given
        Long id = -1L;

        // when
        // then
        Assertions.assertThrows(PropertyReadException.class, () -> {
            propertyService.read(id);
        });
    }
}