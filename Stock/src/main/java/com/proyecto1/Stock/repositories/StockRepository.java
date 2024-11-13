package com.proyecto1.Stock.repositories;

import com.proyecto1.Stock.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByName(String name);

    Optional<Stock> findByCode(String code);
}
