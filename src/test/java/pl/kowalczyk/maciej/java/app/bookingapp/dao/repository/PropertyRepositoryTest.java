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

}