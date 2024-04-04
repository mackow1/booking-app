package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.PropertyMapper;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PropertyService {

    private static final Logger LOGGER = Logger.getLogger(PropertyService.class.getName());

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    public PropertyService(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    public List<Property> list() {
        LOGGER.info("list()");

        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        List<Property> properties = propertyMapper.fromEntities(propertyEntities);

        LOGGER.info("list(...) = " + properties);
        return properties;
    }

    public Property create(Property property) {
        LOGGER.info("create(" + property + ")");

        PropertyEntity propertyEntity = propertyMapper.from(property);
        PropertyEntity savedPropertyEntity = propertyRepository.save(propertyEntity);
        Property savedProperty = propertyMapper.from(savedPropertyEntity);

        LOGGER.info("create(...) = " + savedProperty);
        return savedProperty;
    }
}
