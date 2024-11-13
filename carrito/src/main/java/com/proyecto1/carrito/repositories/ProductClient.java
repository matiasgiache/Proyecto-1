package com.proyecto1.carrito.repositories;

import com.proyecto1.carrito.DTOs.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "producto")
public interface ProductClient {

    @GetMapping("/api/product/name/{name}")
    Optional<ProductDTO> findByName(@PathVariable String name);
}
