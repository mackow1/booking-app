package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.PropertyMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PropertyServiceSpringMockTest {

    public static final String PROPERTY_SERVICE_CREATE_MOCK_TEST_NAME = "PROPERTY SERVICE CREATE MOCK TEST";

    @MockBean
    private PropertyRepository propertyRepository;

    @MockBean
    private PropertyMapper propertyMapper;

    @Autowired
    private PropertyService propertyService;

    @Test
    void givenPropertyWhenCreateThenObjectCreatedProperly() throws PropertyCreateException {
        // given
        Property property = new Property();
        property.setId(123L);
        property.setName(PROPERTY_SERVICE_CREATE_MOCK_TEST_NAME);

        // when
        Mockito.when(propertyService.create(property)).thenReturn(property);
        Property createdProperty = propertyService.create(property);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdProperty, "Property is NULL"),
                () -> Assertions.assertEquals(PROPERTY_SERVICE_CREATE_MOCK_TEST_NAME, createdProperty.getName(), "Property names are not equal")
        );
    }

    @Test
    void givenPropertyWhenCreateThrowsDataAccessException() {
        // given
        Property property = new Property();
        PropertyEntity propertyEntity = new PropertyEntity();

        // when
        Mockito.when(propertyMapper.from(property)).thenReturn(propertyEntity);
        Mockito.when(propertyRepository.save(propertyEntity)).thenThrow(new DataAccessException("Test Exception") {});

        // then
        Assertions.assertThrows(PropertyCreateException.class, () -> {
            propertyService.create(property);
        });
    }
}