package com.proyecto1.producto.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(value = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private Double price;
    private String code;
}
