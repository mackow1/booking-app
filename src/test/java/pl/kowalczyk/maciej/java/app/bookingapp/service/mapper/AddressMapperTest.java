package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressMapperTest {

    public static final Address ADDRESS = new Address("Warszawska 5", "23", "Warszawa", "00-234", "Mazowieckie", "Polska");

    @Test
    void fromAddressToAddressEntity() {
        // given
        AddressMapper addressMapper = new AddressMapper();

        // when
        AddressEntity addressEntity = addressMapper.from(ADDRESS);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(addressEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(ADDRESS.getCity(), addressEntity.getCity(), "Cities are different")
        );
    }

    @Test
    void fromAddressEntityToAddress() {
        // given
        AddressMapper addressMapper = new AddressMapper();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry("Polska");
        addressEntity.setCity("Poznan");
        addressEntity.setId(1L);

        // when
        Address address = addressMapper.from(addressEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(address, "Addess i s NULL"),
                () -> Assertions.assertEquals("Polska", address.getCountry(), "Countries are different")
        );
    }
}