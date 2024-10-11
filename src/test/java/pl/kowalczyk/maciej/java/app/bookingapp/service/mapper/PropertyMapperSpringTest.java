package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import java.util.ArrayList;
import java.util.List;

class PropertyMapperSpringTest {

    public static final String MAPPER_TEST_PROPERTY = "Mapper Test Property";
    public static final String MAPPER_TEST_PROPERTY_ENTITY = "Mapper Test Property Entity";

    @Test
    void fromPropertyToPropertyEntity() {
        // given
        PropertyMapper propertyMapper = new PropertyMapper();
        Property property = new Property();
        property.setId(1L);
        property.setName(MAPPER_TEST_PROPERTY);

        // when
        PropertyEntity propertyEntity = propertyMapper.from(property);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(propertyEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(MAPPER_TEST_PROPERTY, propertyEntity.getName(), "Names are not equal")
        );
    }

    @Test
    void fromPropertyEntityToProperty() {
        // given
        PropertyMapper propertyMapper = new PropertyMapper();
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(2L);
        propertyEntity.setName(MAPPER_TEST_PROPERTY_ENTITY);

        // when
        Property property = propertyMapper.from(propertyEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(property, "Property is NULL"),
                () -> Assertions.assertEquals(MAPPER_TEST_PROPERTY_ENTITY, property.getName(), "Names are not equal")
        );
    }

    @Test
    void fromEntities() {
        // given
        PropertyMapper propertyMapper = new PropertyMapper();
        List<PropertyEntity> propertyEntities = new ArrayList<>();
        propertyEntities.add(new PropertyEntity());

        // when
        List<Property> properties = propertyMapper.fromEntities(propertyEntities);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(properties, "List is NULL"),
                () -> Assertions.assertEquals(propertyEntities.size(), properties.size(), "List length are not equal")
        );
    }
}