package com.proyecto1.carrito.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {

    private Long client_id;

    private String name;
    private boolean isActive;
    private String email;
    private String password;
    private String phoneNum;
}
