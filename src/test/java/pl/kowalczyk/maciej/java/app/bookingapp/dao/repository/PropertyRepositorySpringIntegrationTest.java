package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyRepositorySpringIntegrationTest {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void list() {
        // given
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(12345L);
        propertyEntity.setName("Villa Polska");

        propertyRepository.save(propertyEntity);

        // when
        List<PropertyEntity> properties = propertyRepository.findAll();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(properties, "List is NULL"),
                () -> Assertions.assertEquals(1, properties.size(), "List size is not equal 1")
        );
    }
}