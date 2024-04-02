package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

import java.util.logging.Logger;

@Component
public class AddressMapper {

    private static final Logger LOGGER = Logger.getLogger(AddressMapper.class.getName());

    public AddressEntity from(Address address) {
        LOGGER.info("from(" + address + ")");

        ModelMapper modelMapper = new ModelMapper();
        AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);

        LOGGER.info("from(...) = " + addressEntity);
        return addressEntity;
    }

    public Address from(AddressEntity addressEntity) {
        LOGGER.info("from(" + addressEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        Address address = modelMapper.map(addressEntity, Address.class);

        LOGGER.info("from(...) = " + address);
        return address;
    }
}
