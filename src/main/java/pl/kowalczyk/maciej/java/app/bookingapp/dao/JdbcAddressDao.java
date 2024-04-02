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

    @Override
    public AddressEntity read(Long id) {
        LOGGER.info("read(" + id + ")");
        AddressEntity addressFound = null;
        LOGGER.info("read(...) = " + addressFound);
        return addressFound;
    }

    @Override
    public AddressEntity update(AddressEntity addressEntity) {
        LOGGER.info("update(" + addressEntity + ")");
        AddressEntity updatedAddressEntity = null;
        LOGGER.info("update(...) = " + updatedAddressEntity);
        return null;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        LOGGER.info("delete(...)");
    }
}
