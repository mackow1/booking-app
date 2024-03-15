package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.AddressDao;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {

    @Test
    void create() {
        // given
        Address address = new Address();
        AddressDao addressDao = new AddressDao();

        AddressService addressService = new AddressService(addressDao);

        // when

        // then

    }

    @Test
    void testCreate() {
    }
}