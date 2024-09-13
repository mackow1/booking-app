package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role.RoleReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.HostRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
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
    private final HostRepository hostRepository;

    public PropertyService(PropertyRepository propertyRepository, PropertyMapper propertyMapper, HostRepository hostRepository) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
        this.hostRepository = hostRepository;
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

        Long hostId = property.getHostId();

        try {
            PropertyEntity propertyEntity = propertyMapper.from(property);

            if (hostId != null) {
                Optional<HostEntity> optionalHostEntity = hostRepository.findById(hostId);
                HostEntity hostEntity = optionalHostEntity.orElseThrow(() -> {
                    LOGGER.log(Level.SEVERE, "No host found for id: " + hostId);
                    return new PropertyCreateException("Host not found for given id: " + hostId);
                });

                propertyEntity.setHost(hostEntity);
            }

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

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(id);
        PropertyEntity propertyEntity = optionalPropertyEntity.orElseThrow(() -> {
                    LOGGER.log(Level.SEVERE, "Property not found for given id: " + id);
                    return new PropertyReadException("Property not found for given id: " + id);
                }
        );

        Property property = propertyMapper.from(propertyEntity);

        LOGGER.info("read(...) = " + property);
        return property;
    }

    public Property update(Property property) throws PropertyUpdateException {
        LOGGER.info("update(" + property + ")");

        if (property == null) {
            throw new PropertyUpdateException("Model must not be null");
        }

        try {
            PropertyEntity propertyEntity = propertyMapper.from(property);
            PropertyEntity updatedPropertyEntity = propertyRepository.save(propertyEntity);
            Property updatedProperty = propertyMapper.from(updatedPropertyEntity);

            LOGGER.info("update(...) = " + updatedProperty);
            return updatedProperty;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while updating property: " + property, e);
            throw new PropertyUpdateException("Database access error while updating property: " + property);
        }
    }

    public void delete(Long id) throws PropertyDeleteException {
        LOGGER.info("delete(" + id + ")");

        try {
            propertyRepository.deleteById(id);
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while deleting property with ID: " + id, e);
            throw new PropertyDeleteException("Error while deleting property with ID: " + id);
        }

        LOGGER.info("delete(...) = ");
    }
}
