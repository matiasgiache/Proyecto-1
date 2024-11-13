package com.proyecto1.Stock.services;

import com.proyecto1.Stock.entities.Stock;
import com.proyecto1.Stock.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock create(Stock stock){
        return stockRepository.save(stock);
    }

    public Optional<Stock> findByName(String name){
        return stockRepository.findByName(name);
    }

    public Optional<Stock> findByCode(String code){
        return stockRepository.findByCode(code);
    }

    public Optional<Stock> findById(Long id){
        return stockRepository.findById(id);
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }

    public Stock update(String code, Stock stock){

        Optional<Stock> stockToUp = findByCode(code);

        if (stockToUp.isPresent()){
            Stock stock1 = stockToUp.get();

            stock1.setCode(stock.getCode());
            stock1.setName(stock.getName());
            stock1.setQuantity(stock.getQuantity());

            return stockRepository.save(stock1);
        }

        return null;
    }

    public void changeQuantity(String code, Integer quantity){

        Optional<Stock> stock = findByCode(code);

        if (stock.isPresent()){
            Stock stock1 = stock.get();

            stock1.setQuantity(quantity);

            stockRepository.save(stock1);
        }
    }

    public void delete(String code){
        Long id = findByCode(code).get().getId();

        stockRepository.deleteById(id);
    }
}
