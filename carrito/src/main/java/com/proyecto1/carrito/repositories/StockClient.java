package com.proyecto1.carrito.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Stock")
public interface StockClient {

    @GetMapping("/api/stock/available/{name}")
    boolean isAvailable(@PathVariable String name);
}
