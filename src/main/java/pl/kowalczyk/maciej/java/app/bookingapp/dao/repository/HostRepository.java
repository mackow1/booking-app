package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;

@Repository
public interface HostRepository extends JpaRepository<HostEntity, Long> {
}
