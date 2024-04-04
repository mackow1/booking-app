package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.springframework.stereotype.Repository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.AddressDao;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;

import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class DataJpaAddressRepository implements AddressDao {

    private static final Logger LOGGER = Logger.getLogger(DataJpaAddressRepository.class.getName());

    private final AddressRepository addressRepository;

    public DataJpaAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressEntity create(AddressEntity addressEntity) {
        LOGGER.info("create(" + addressEntity + ")");

        AddressEntity savedAddressEntity = addressRepository.save(addressEntity);

        LOGGER.info("create(...) = " + savedAddressEntity);
        return null;
    }

    @Override
    public AddressEntity read(Long id) throws Exception {
        LOGGER.info("read(" + id + ")");

        Optional<AddressEntity> addressEntityOptional = addressRepository.findById(id);
        AddressEntity foundAddressEntity = addressEntityOptional.orElseThrow(
                () -> new Exception("Unable to find Address")
        );

        LOGGER.info("read(...) = " + foundAddressEntity);
        return null;
    }

    @Override
    public AddressEntity update(AddressEntity addressEntity) {
        LOGGER.info("update(" + addressEntity + ")");

        AddressEntity updatedAddressEntity = addressRepository.save(addressEntity);

        LOGGER.info("update(...) = " + updatedAddressEntity);
        return null;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        addressRepository.deleteById(id);

        LOGGER.info("delete(...) = ");
    }
}
