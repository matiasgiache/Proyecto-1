package com.proyecto1.cliente.services;

import com.proyecto1.cliente.entities.Client;
import com.proyecto1.cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

    public Optional<Client> findByName(String name){
        return clientRepository.findByName(name);
    }

    public Client update(Client client, Long id){

        Optional<Client> clientOptional = findById(id);

        if (clientOptional.isPresent()){
            Client client1 = clientOptional.get();

            client1.setActive(client.isActive());
            client1.setName(client.getName());
            client1.setEmail(client.getEmail());
            client1.setPassword(client.getPassword());
            client1.setPhoneNum(client.getPhoneNum());
            client1.setCarts_list(client.getCarts_list());

            return create(client1);
        }

        return null;
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }
}
