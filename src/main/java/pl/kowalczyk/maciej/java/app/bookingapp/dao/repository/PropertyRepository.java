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
    @Transactional
//    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE properties p SET p.HOST_ID = NULL WHERE p.HOST_ID = ?", nativeQuery = true)
//    @Query("UPDATE PropertyEntity p SET p.host = NULL WHERE p.host.id = :hostId")
    void deleteHostIdFromProperties(@Param("hostId") Long hostId);

    List<PropertyEntity> findByHost_Id(Long hostId);
}
