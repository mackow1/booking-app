package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    void findByHostId() {
        // given
        HostEntity hostEntity = new HostEntity();
        hostEntity.setName("Mateusz");

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity("Warszawa");
        
        PropertyEntity firstPropertyEntity = new PropertyEntity();
        firstPropertyEntity.setName("first");
//        firstPropertyEntity.setAddress(addressEntity);
        PropertyEntity secondPropertyEntity = new PropertyEntity();
        secondPropertyEntity.setName("second");
//        secondPropertyEntity.setAddress(addressEntity);

        // when
        HostEntity savedHostEntity = hostRepository.save(hostEntity);
//        Long savedHostId = savedHostEntity.getId();

        firstPropertyEntity.setHost(savedHostEntity);
        secondPropertyEntity.setHost(savedHostEntity);

//        propertyRepository.saveAllAndFlush(List.of(firstPropertyEntity, secondPropertyEntity));
        propertyRepository.save(firstPropertyEntity);
        propertyRepository.save(secondPropertyEntity);

//        propertyRepository.
//
        List<PropertyEntity> listOfHostsProperties = propertyRepository.findByHost_Id(1L);

//        propertyRepository.findById(1L);
        // then
//        Assertions.assertAll(
//                () -> assertNotNull(listOfHostsProperties, "List is NULL")
//                ,
//                () -> assertEquals(2, listOfHostsProperties.size(), "List size in not equal 2")
//        );
    }

}