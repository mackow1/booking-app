package pl.kowalczyk.maciej.java.app.bookingapp.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.HostRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.PropertyRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HostServiceIntegrationSpringTest {

    public static final String KRZYSZTOF_HOST_NAME = "Krzysztof";
    public static final String HOST_MAIL = "testmail@test.pl";

    @Autowired
    private HostService hostService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void givenHostEntityAndHostIdWhenReadThenHostFound() throws HostCreateException, HostReadException {
        // given
        Host host = new Host();
        host.setName(KRZYSZTOF_HOST_NAME);
        host.setEmail(HOST_MAIL);

        Host hostCreated = hostService.create(host);
        Long id = hostCreated.getId();

        // when
        Host readHost = hostService.read(id);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readHost, "Host is NULL"),
                () -> Assertions.assertEquals(HOST_MAIL, readHost.getEmail(), "Emails are not equal")
        );
    }

    @Test
    void givenHostWhenUpdateThenHostUpdated() throws HostCreateException, HostUpdateException {
        // given
        Host host = new Host();
        host.setName(KRZYSZTOF_HOST_NAME);
        host.setEmail(HOST_MAIL);

        Host hostCreated = hostService.create(host);
        Long id = hostCreated.getId();

        String nameMarcin = "Marcin";
        String mailMarcin = "marcintest@mail.com";

        Host hostForUpdate =new Host();
        hostForUpdate.setId(id);
        hostForUpdate.setName(nameMarcin);
        hostForUpdate.setEmail(mailMarcin);

        // when
        Host updatedHost = hostService.update(hostForUpdate);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updatedHost, "Host is NULL"),
                () -> Assertions.assertEquals(mailMarcin, updatedHost.getEmail(), "Mails are not equal")
        );

    }

    @Test
    void givenHostIdWhenDeleteThenHostDeleted() throws HostCreateException, HostDeleteException {
        // given
        Host host = new Host();
        host.setName("Daniel");
        host.setEmail("daniel@gmail.com");

        Host hostCreated = hostService.create(host);
        Long id = hostCreated.getId();

        // when
        hostService.delete(id);

        // then
        Assertions.assertThrows(HostReadException.class, () -> hostService.read(id));
    }

    @Test
    @Transactional
    void givenHostWithPropertiesWhenDeleteThenHostDeletedAndPropertiesHostSetToNull() throws HostDeleteException {
        // given
        HostEntity hostEntity = new HostEntity();
        hostEntity.setName("Jon");

        PropertyEntity firstPtPropertyEntity = new PropertyEntity();
        firstPtPropertyEntity.setName("Villa pierwsza");

        PropertyEntity secondPtPropertyEntity = new PropertyEntity();
        firstPtPropertyEntity.setName("Villa druga");

        // when
        HostEntity savedHostEntity = hostRepository.save(hostEntity);
        Long savedHostEntityId = savedHostEntity.getId();

        firstPtPropertyEntity.setHost(savedHostEntity);
        secondPtPropertyEntity.setHost(savedHostEntity);

        PropertyEntity savedFirsPropertyEntity = propertyRepository.save(firstPtPropertyEntity);
        Long savedFirsPropertyEntityId = savedFirsPropertyEntity.getId();

        PropertyEntity savedSecondPropertyEntity = propertyRepository.save(secondPtPropertyEntity);
        Long savedSecondPropertyEntityId = savedSecondPropertyEntity.getId();

        hostService.delete(savedHostEntityId);

        Optional<PropertyEntity> optionalFirstPropertyEntity = propertyRepository.findById(savedFirsPropertyEntityId);
        PropertyEntity foundFirstPropertyEntity = optionalFirstPropertyEntity.orElse(null);

        Optional<PropertyEntity> optionalSecondPropertyEntity = propertyRepository.findById(savedSecondPropertyEntityId);
        PropertyEntity foundSecondPropertyEntity = optionalSecondPropertyEntity.orElse(null);

        // then
        Assertions.assertAll(
                () -> Assertions.assertThrows(Exception.class, () -> hostService.read(savedHostEntityId)),
                () -> Assertions.assertNull(foundFirstPropertyEntity.getHost(), "Host is not NULL"),
                () -> Assertions.assertNull(foundSecondPropertyEntity.getHost(), "Host is not NULL")
        );
    }

    @Test
    @Transactional
    void givenHostWithPropertiesWhenDeleteAndDeleteHostIdFromPropertiesThenHostDeletedAndPropertiesHostSetToNull() throws HostCreateException, PropertyCreateException, PropertyReadException {
        // given
        Host host = new Host();
        host.setName("Jon");

        Property firstProperty = new Property();
        firstProperty.setName("Villa pierwsza");

        Property secondProperty = new Property();
        secondProperty.setName("Villa druga");

        // when
        Host hostCreated = hostService.create(host);
        Long hostCreatedId = hostCreated.getId();

        firstProperty.setHost(hostCreated);
        secondProperty.setHost(hostCreated);

        Property firstPropertyCreated = propertyService.create(firstProperty);
        Long firstPropertyCreatedId = firstPropertyCreated.getId();

        Property secondPropertyCreated = propertyService.create(secondProperty);
        Long secondPropertyCreatedId = secondPropertyCreated.getId();

//        propertyRepository.deleteHostIdFromProperties(hostCreatedId);

        Property readFirstProperty = propertyService.read(firstPropertyCreatedId);
        Property readSecondProperty = propertyService.read(secondPropertyCreatedId);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNull(readFirstProperty.getHost(), "Host is not NULL"),
                () -> Assertions.assertNull(readSecondProperty.getHost(), "Host is not NULL")
        );
    }
}