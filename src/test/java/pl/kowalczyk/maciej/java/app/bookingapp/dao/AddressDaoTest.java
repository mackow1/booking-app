package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

class AddressDaoTest {

    @Test
    void create() {
        // given
        AddressDao addressDao = new AddressDao();
        Address address = new Address();

        // when
        Address createdAddress = addressDao.create(address);

        // then
        Assertions.assertNotNull(createdAddress, "Address not created");
    }

    @Test
    void read() {
        // given
        AddressDao addressDao = new AddressDao();
        int id = 0;

        // when
        Address addressFound = addressDao.read(id);

        // then
        Assertions.assertNotNull(addressFound, "Address not found");
    }
}
