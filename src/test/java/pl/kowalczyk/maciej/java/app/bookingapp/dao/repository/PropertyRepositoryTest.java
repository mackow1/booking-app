package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyRepositoryTest {
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

}