package com.proyecto1.carrito.DTOs;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDTO {

    private Long cart_id;
    private LocalDate date;
    private Double total;
    private List<ProductDTO> products_list;
    private ClientDTO clientDTO;
}
