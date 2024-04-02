package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

class JdbcAddressDaoTest {

    @Test
    void create() {
        // given
        JdbcAddressDao jdbcAddressDao = new JdbcAddressDao();
        Address address = new Address();

        // when
        Address createdAddress = jdbcAddressDao.create(address);

        // then
        Assertions.assertNotNull(createdAddress, "Address not created");
    }

    @Test
    void read() {
        // given
        JdbcAddressDao jdbcAddressDao = new JdbcAddressDao();
        int id = 0;

        // when
        Address addressFound = jdbcAddressDao.read(id);

        // then
        Assertions.assertNotNull(addressFound, "Address not found");
    }
}
