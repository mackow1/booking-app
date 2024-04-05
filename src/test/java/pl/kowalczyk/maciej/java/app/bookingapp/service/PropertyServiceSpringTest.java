package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyServiceSpringTest {

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
}