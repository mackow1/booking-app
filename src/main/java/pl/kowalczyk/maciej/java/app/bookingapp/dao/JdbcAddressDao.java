package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

import java.util.logging.Logger;

public class JdbcAddressDao implements AddressDao {

    private static final Logger LOGGER = Logger.getLogger(JdbcAddressDao.class.getName());

    @Override
    public AddressEntity create(AddressEntity address) {
        LOGGER.info("create(" + address + ")");
        AddressEntity createdAddress = null;
        LOGGER.info("create(...) = " + createdAddress);
        return createdAddress;
    }

    public Address read(int id) {
        LOGGER.info("read(" + id + ")");
        Address addressFound = null;
        LOGGER.info("read(...) = " + addressFound);
        return addressFound;
    }
}
