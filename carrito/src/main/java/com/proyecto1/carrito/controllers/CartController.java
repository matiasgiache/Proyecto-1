package com.proyecto1.carrito.controllers;

import com.proyecto1.carrito.DTOs.CartDTO;
import com.proyecto1.carrito.entities.Cart;
import com.proyecto1.carrito.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    @GetMapping("/allByClient/{client_id}")
    public List<Cart> findAllByClientId(@PathVariable Long client_id){
        return cartService.findAllByClientId(client_id);
    }

    @GetMapping("/id/{cart_id}")
    public CartDTO findById(@PathVariable Long cart_id){
        return cartService.findById(cart_id);
    }

    @PostMapping("/create")
    public Cart saveCart(@RequestBody Cart cart){
        return cartService.create(cart);
    }

    @PutMapping("/addProduct/{cart_id}")
    public String addProduct(@PathVariable Long cart_id, @Param("name") String name){
        return cartService.addProduct(cart_id, name);
    }

    @PutMapping("/update/{cart_id}")
    public Cart updateCart(@PathVariable Long cart_id, @RequestBody Cart cart){
        return cartService.update(cart, cart_id);
    }

    @DeleteMapping("/delete/{cart_id}")
    public String deleteCart(@PathVariable Long cart_id){
        cartService.delete(cart_id);
        return "Cart deleted Successfully";
    }
}
