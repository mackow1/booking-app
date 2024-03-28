package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
