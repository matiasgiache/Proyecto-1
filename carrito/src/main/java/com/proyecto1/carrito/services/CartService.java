package com.proyecto1.carrito.services;

import com.proyecto1.carrito.DTOs.CartDTO;
import com.proyecto1.carrito.Utils.EntityUtils;
import com.proyecto1.carrito.entities.Cart;
import com.proyecto1.carrito.repositories.CartRepository;
import com.proyecto1.carrito.repositories.StockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private EntityUtils entityUtils;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private StockClient stockClient;

    public Cart create(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }

    public List<Cart> findAllByClientId(Long client_id){
        return cartRepository.findAllByClientId(client_id);
    }

    public CartDTO findById(Long cart_id){

        return entityUtils.cartToDto(cartRepository.findById(cart_id).orElseThrow());
    }

    public Cart update(Cart cart, Long cart_id){

        Optional<Cart> cartToUp = cartRepository.findById(cart_id);

        if (cartToUp.isPresent()){
            Cart cart1 = cartToUp.get();

            cart1.setDate(cart.getDate());
            cart1.setTotal(cart.getTotal());
            cart1.setClient_id(cart.getClient_id());
            cart1.setProducts_list(cart.getProducts_list());

            return cartRepository.save(cart1);
        }

        return null;
    }

    public String addProduct(Long cart_id, String name){

        if (stockClient.isAvailable(name)){

            Optional<Cart> cart = cartRepository.findById(cart_id);
            if (cart.isPresent()){
                Cart cart1 = cart.get();
                List<String> products_list = cart1.getProducts_list();
                products_list.add(name);
                cart1.setProducts_list(products_list);
                cartRepository.save(cart1);

                return "Product added successfully to cart.";
            }else {
                return "Cart not Found.";
            }
        }else {
            return "Stock not available.";
        }
    }

    public void delete(Long cart_id){
        cartRepository.deleteById(cart_id);
    }
}
