package com.proyecto1.carrito.repositories;

import com.proyecto1.carrito.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.client_id = :client_id")
    List<Cart> findAllByClientId(@Param("client_id") Long client_id);
}
