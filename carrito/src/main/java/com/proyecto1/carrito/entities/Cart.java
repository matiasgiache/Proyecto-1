package com.proyecto1.carrito.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    private Double total;
    private List<String> products_list;
    private Long client_id;
}
