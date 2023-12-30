package com.rochdi.clientservice.controllers;

import com.rochdi.clientservice.entities.Client;
import com.rochdi.clientservice.repositories.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping()
    List<Client> listClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    Client findClientById(@PathVariable final Long id) {
        return clientRepository.findById(id).orElseThrow();
    }
}
