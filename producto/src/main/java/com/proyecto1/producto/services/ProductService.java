package com.proyecto1.producto.services;

import com.proyecto1.producto.entities.Product;
import com.proyecto1.producto.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(String id){
        return productRepository.findById(id);
    }

    public Optional<Product> findByName(String name){
        return productRepository.findByName(name);
    }

    public Product update(Product product, String id){

        Optional<Product> prodToUp = getProduct(id);

        if (prodToUp.isPresent()){
            Product product1 = prodToUp.get();
            product1.setPrice(product.getPrice());
            product1.setCode(product.getCode());
            product1.setName(product.getName());
            return createProduct(product1);
        }
        return null;
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }
}
