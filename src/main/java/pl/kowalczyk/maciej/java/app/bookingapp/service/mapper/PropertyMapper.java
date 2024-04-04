package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class PropertyMapper {

    private static final Logger LOGGER = Logger.getLogger(PropertyMapper.class.getName());

    public PropertyEntity from(Property property) {
        LOGGER.info("(" + property + ")");

        ModelMapper modelMapper = new ModelMapper();
        PropertyEntity propertyEntity = modelMapper.map(property, PropertyEntity.class);

        LOGGER.info("(...) = " + propertyEntity);
        return propertyEntity;
    }

    public Property from(PropertyEntity propertyEntity) {
        LOGGER.info("(" + propertyEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        Property property = modelMapper.map(propertyEntity, Property.class);

        LOGGER.info("(...) = " + property);
        return property;
    }

    public List<Property> fromEntities(List<PropertyEntity> propertyEntities) {
        LOGGER.info("fromEntities(" + propertyEntities + ")");

        List<Property> properties = propertyEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + properties);
        return properties;
    }
}
