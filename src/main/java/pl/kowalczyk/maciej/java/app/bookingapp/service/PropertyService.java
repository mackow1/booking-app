package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.PropertyMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
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

    public Property create(Property property) throws PropertyCreateException {
        LOGGER.info("create(" + property + ")");

        if (property == null) {
            throw new PropertyCreateException("Property must not be null");
        }

        try {
            PropertyEntity propertyEntity = propertyMapper.from(property);
            PropertyEntity savedPropertyEntity = propertyRepository.save(propertyEntity);
            Property savedProperty = propertyMapper.from(savedPropertyEntity);

            LOGGER.info("create(...) = " + savedProperty);
            return savedProperty;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while saving property: " + property, e);
            throw new PropertyCreateException("Database access error while saving property:" + property);
        }
    }

    public Property read(Long id) throws PropertyReadException {
        LOGGER.info("read(" + id + ")");

        if (id == null) {
            throw new PropertyReadException("ID must not be NULL");
        }

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(id);
//        optionalPropertyEntity.orElseThrow(() -> {
//                    LOGGER.log(Level.SEVERE, "Property not found given id");
//                }
//        );

        Property result = null;

        LOGGER.info("read(...) = " + result);
        return result;
    }
}
