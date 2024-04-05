package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.address.AddressReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.AddressDao;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.DataJpaAddressRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.AddressMapper;

import java.util.logging.Logger;

@Service
public class AddressService {

    private static final Logger LOGGER = Logger.getLogger(AddressService.class.getName());

    private final AddressMapper addressMapper;
    private final DataJpaAddressRepository dataJpaAddressRepository;

    public AddressService(DataJpaAddressRepository dataJpaAddressRepository, AddressMapper addressMapper) {
        this.dataJpaAddressRepository = dataJpaAddressRepository;
        this.addressMapper = addressMapper;
    }

    public Address create(Address address) {
        LOGGER.info("create()");

        AddressEntity addressEntity = addressMapper.from(address);
        AddressEntity createdAddressEntity = dataJpaAddressRepository.create(addressEntity);
        Address mappedAddress = addressMapper.from(createdAddressEntity);

        LOGGER.info("create(...) = " + mappedAddress);
        return mappedAddress;
    }

    public Address read(Long id) throws AddressReadException {
        LOGGER.info("read(" + id + ")");

        AddressEntity readAddressEntity = dataJpaAddressRepository.read(id);
        Address addressRead = addressMapper.from(readAddressEntity);

        LOGGER.info("read(...) = " + addressRead);
        return addressRead;
    }

    public Address update(Address address) {
        LOGGER.info("update(" + address + ")");

        AddressEntity addressEntity = addressMapper.from(address);
        AddressEntity updateAddressEntity = dataJpaAddressRepository.update(addressEntity);
        Address updatedAddress = addressMapper.from(updateAddressEntity);

        LOGGER.info("update(...) = " + updatedAddress);
        return updatedAddress;
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        dataJpaAddressRepository.delete(id);

        LOGGER.info("delete(...) = ");
    }
}
