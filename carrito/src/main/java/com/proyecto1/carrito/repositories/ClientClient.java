package com.proyecto1.carrito.repositories;

import com.proyecto1.carrito.DTOs.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "cliente")
public interface ClientClient {

    @GetMapping("/api/client/id/{client_id}")
    Optional<ClientDTO> findById(@PathVariable Long client_id);
}
