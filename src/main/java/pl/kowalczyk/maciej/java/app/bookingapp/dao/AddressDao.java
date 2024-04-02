package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;

public interface AddressDao {
    AddressEntity create(AddressEntity addressEntity);
    AddressEntity read(Long id) throws Exception;
    AddressEntity update(AddressEntity addressEntity);
    void delete(Long id);
}
