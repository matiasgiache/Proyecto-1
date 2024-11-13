package com.proyecto1.carrito.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private String product_id;
    private String name;
    private Double price;
    private String code;
}
