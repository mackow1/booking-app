package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PropertyRepositoryTest {

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void test() {
        // given
        HostEntity hostEntity = new HostEntity();
        hostEntity.setName("Gortad");

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setHost(hostEntity);

        // when
        propertyRepository.save(propertyEntity);

        // then

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void findByHostId() {
        // given
        HostEntity mateuszHostEntity = new HostEntity();
        mateuszHostEntity.setName("Mateusz");

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity("Warszawa");
        
        PropertyEntity firstPropertyEntity = new PropertyEntity();
        firstPropertyEntity.setName("first");
        PropertyEntity secondPropertyEntity = new PropertyEntity();
        secondPropertyEntity.setName("second");

        // when
        HostEntity savedMateuszHostEntity = hostRepository.save(mateuszHostEntity);

        firstPropertyEntity.setHost(savedMateuszHostEntity);
        secondPropertyEntity.setHost(savedMateuszHostEntity);

        propertyRepository.save(firstPropertyEntity);
        propertyRepository.save(secondPropertyEntity);

        List<PropertyEntity> foundPropertiesByHostId = propertyRepository.findByHost_Id(1L);
        System.out.println(foundPropertiesByHostId);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(foundPropertiesByHostId, "List is NULL"),
                () -> Assertions.assertEquals(2, foundPropertiesByHostId.size(), "List size in not equal 2")
        );
    }

    @Test
    @Transactional
    void deleteHostIdFromProperties() {
        // given
        HostEntity hostEntity = new HostEntity();
        hostEntity.setName("Sam");

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setName("Sam's property");

        // when
        HostEntity savedHostEntity = hostRepository.save(hostEntity);
        Long savedHostEntityId = savedHostEntity.getId();
        propertyEntity.setHost(hostEntity);

        PropertyEntity savedPropertyEntity = propertyRepository.save(propertyEntity);
        Long savedPropertyEntityId = savedPropertyEntity.getId();

        propertyRepository.deleteHostIdFromProperties(savedHostEntityId);

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(savedPropertyEntityId);
        PropertyEntity readPropertyEntity = optionalPropertyEntity.orElse(null);

        // then
        Assertions.assertNull(readPropertyEntity.getHost(), "Host is not NULL");
    }

}