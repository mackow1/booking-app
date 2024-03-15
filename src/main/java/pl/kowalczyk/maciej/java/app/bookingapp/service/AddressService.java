package pl.kowalczyk.maciej.java.app.bookingapp.service;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.AddressDao;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.AddressMapper;

import java.util.logging.Logger;

public class AddressService {

    private static final Logger LOGGER = Logger.getLogger(AddressService.class.getName());

    private AddressDao addressDao;

    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public Address create(Address address) {
        LOGGER.info("create()");

        AddressMapper addressMapper = new AddressMapper();
        AddressEntity addressEntity = addressMapper.from(address);
        AddressEntity createdAddressEntity = addressDao.create(addressEntity);
        Address mappedAddress = addressMapper.from(createdAddressEntity);

        LOGGER.info("create(...) = " + mappedAddress);
        return mappedAddress;
    }
}
