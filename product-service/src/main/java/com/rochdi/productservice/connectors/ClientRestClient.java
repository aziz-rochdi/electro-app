package com.rochdi.productservice.connectors;

import com.rochdi.productservice.models.Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping("/clients")
    List<Client> findAllClients();
    @GetMapping("/clients/{id}")
    @CircuitBreaker(name = "clientService", fallbackMethod = "getDefaultClient")
    Client findClientById(@PathVariable Long id);

    default Client getDefaultClient(Long id, Exception exception) {
        return Client.builder()
                .id(id)
                .email("not Available")
                .firstName("not Available")
                .lastName("not Available")
                .phone("not Available")
                .build();
    }
}
