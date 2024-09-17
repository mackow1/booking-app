package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    List<PropertyEntity> findByHost_Id(Long hostId);
}
