package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.PropertyEntity;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE properties SET host_id = NULL WHERE host_id = :hostId", nativeQuery = true)
    void deleteHostIdFromProperties(@Param("hostId") Long hostId);

    List<PropertyEntity> findByHost_Id(Long hostId);
}
