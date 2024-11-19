package com.proyecto1.Stock.controllers;

import com.proyecto1.Stock.entities.Stock;
import com.proyecto1.Stock.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Stock> findAll(){
        return stockService.findAll();
    }

    @GetMapping("/available/{name}")
    @ResponseStatus(HttpStatus.CONTINUE)
    public boolean isAvailable(@PathVariable String name){
        return stockService.isAvailable(name);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Stock> findById(@PathVariable Long id){
        return stockService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Stock create(@RequestBody Stock stock){
        return stockService.create(stock);
    }

    @PatchMapping("/change")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String changeQuantity(@Param("code") String code,
                                 @Param("quantity") Integer quantity){

        stockService.changeQuantity(code,quantity);
        return "Product: code: " + code + ", quantity change to: " + quantity.toString();
    }

    @PutMapping("/update/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Stock update(@PathVariable String code, @RequestBody Stock stock){
        return stockService.update(code,stock);
    }

    @DeleteMapping("/delete/{code}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable String code){
        stockService.delete(code);

        return "Product deleted from stock.";
    }

}
