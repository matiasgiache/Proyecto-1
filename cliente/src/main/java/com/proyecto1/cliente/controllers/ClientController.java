package com.proyecto1.cliente.controllers;

import com.proyecto1.cliente.entities.Client;
import com.proyecto1.cliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findByName(@PathVariable String name){
        return clientService.findByName(name);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return clientService.create(client);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        return clientService.update(client, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteClient(@PathVariable Long id){
        clientService.delete(id);

        return "Client successfully deleted.";
    }

}
