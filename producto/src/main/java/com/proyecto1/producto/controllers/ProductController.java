package com.proyecto1.producto.controllers;

import com.proyecto1.producto.entities.Product;
import com.proyecto1.producto.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> findById(@PathVariable String id){
        return productService.getProduct(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@PathVariable String id,@RequestBody Product product){
        return productService.update(product,id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@PathVariable String id){
        productService.delete(id);

        return "Product successfully deleted.";
    }

}
