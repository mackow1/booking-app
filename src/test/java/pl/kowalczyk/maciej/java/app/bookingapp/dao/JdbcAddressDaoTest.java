package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

class JdbcAddressDaoTest {

    @Test
    void create() {
        // given
        JdbcAddressDao jdbcAddressDao = new JdbcAddressDao();
        AddressEntity addressEntity = new AddressEntity();

        // when
        AddressEntity createdAddress = jdbcAddressDao.create(addressEntity);

        // then
        Assertions.assertNotNull(createdAddress, "Address not created");
    }

    @Test
    void read() {
        // given
        JdbcAddressDao jdbcAddressDao = new JdbcAddressDao();
        Long id = 1L;

        // when
        AddressEntity addressFound = jdbcAddressDao.read(id);

        // then
        Assertions.assertNotNull(addressFound, "Address not found");
    }
}
