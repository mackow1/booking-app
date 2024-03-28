package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.AddressDao;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;

public class DataJpaAddressRepository implements AddressDao {
    private final AddressRepository addressRepository;

    public DataJpaAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressEntity create(AddressEntity addressEntity) {
        AddressEntity savedAddressEntity = addressRepository.save(addressEntity);
        return null;
    }
}
