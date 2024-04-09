package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceSpringTest {

    public static final String WARSZAWA_CITY_NAME = "Warszawa_create_test";

    @Autowired
    private AddressService addressService;

    @Test
    void create() {
        // given
        Address address = new Address();
        address.setCity(WARSZAWA_CITY_NAME);
        address.setCountry("Polska");

        // when
        Address addressCreated = addressService.create(address);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(addressCreated, "Address is NULL"),
                () -> Assertions.assertEquals(WARSZAWA_CITY_NAME, addressCreated.getCity(), "City names are not equal")
        );
    }
}