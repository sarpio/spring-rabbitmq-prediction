package com.example.agregator.repo;

import com.example.agregator.model.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

    List<ExchangeRateEntity> findTop10ByOrderByIdDesc();

    @Query(value = "SELECT * FROM exchange_rate e ORDER BY e.id DESC LIMIT 25", nativeQuery = true)
    List<ExchangeRateEntity> findLast25Records();
}
