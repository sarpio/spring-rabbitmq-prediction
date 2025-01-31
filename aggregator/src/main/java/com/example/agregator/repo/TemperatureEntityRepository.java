package com.example.agregator.repo;

import com.example.agregator.model.TemperatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureEntityRepository extends JpaRepository<TemperatureEntity, Long> {

    List<TemperatureEntity> findTop10ByOrderByIdDesc();

    @Query(value = "SELECT * FROM temperature t ORDER BY t.id DESC LIMIT 25", nativeQuery = true)
    List<TemperatureEntity> findLast25Records();
}
