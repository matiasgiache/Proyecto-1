package com.proyecto1.carrito.Utils;

import com.proyecto1.carrito.DTOs.CartDTO;
import com.proyecto1.carrito.DTOs.ProductDTO;
import com.proyecto1.carrito.entities.Cart;
import com.proyecto1.carrito.repositories.ClientClient;
import com.proyecto1.carrito.repositories.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityUtils {

    @Autowired
    private ClientClient clientClient;

    @Autowired
    private ProductClient productClient;

    public CartDTO cartToDto(Cart cart){

        CartDTO cartDTO = new CartDTO();

        cartDTO.setCart_id(cart.getCart_id());
        cartDTO.setDate(cart.getDate());
        cartDTO.setTotal(cart.getTotal());
        cartDTO.setProducts_list(fillProductDTOList(cart));
        cartDTO.setClientDTO(clientClient.findById(cart.getClient_id()).orElse(null));

        return cartDTO;
    }

    public List<ProductDTO> fillProductDTOList(Cart cart){

        List<ProductDTO> products_list = new ArrayList<>();

        for (String name : cart.getProducts_list()){
            products_list.add(productClient.findByName(name).orElse(null));
        }

        return products_list;
    }

    public Cart dtoToCart(CartDTO cartDTO){

        Cart cart = new Cart();

        cart.setClient_id(cartDTO.getClientDTO().getClient_id());
        cart.setCart_id(cartDTO.getCart_id());
        cart.setDate(cartDTO.getDate());
        cart.setTotal(cartDTO.getTotal());
        cart.setProducts_list(fillProductList(cartDTO));

        return cart;
    }

    public List<String> fillProductList(CartDTO cartDTO){

        List<String> products_list = new ArrayList<>();

        for (ProductDTO productDTO : cartDTO.getProducts_list()) {

            products_list.add(productDTO.getName());
        }

        return products_list;
    }
}
