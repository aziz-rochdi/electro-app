package com.rochdi.productservice.controllers;

import com.rochdi.productservice.connectors.ClientRestClient;
import com.rochdi.productservice.entities.Product;
import com.rochdi.productservice.models.Client;
import com.rochdi.productservice.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ClientRestClient clientRestClient;

    public ProductController(final ProductRepository productRepository, ClientRestClient clientRestClient) {
        this.productRepository = productRepository;
        this.clientRestClient = clientRestClient;
    }
    @GetMapping
    public List<Product> listProducts() {
        List<Product> products = this.productRepository.findAll();
        products.forEach(this::setClient);
        return products;
    }

    public void setClient(Product product){
        Client client = this.clientRestClient.findClientById(product.getClientId());
        product.setClient(client);
    }

    @GetMapping("/{id}")
    public Product productById(@PathVariable final Long id) {
        Product product = this.productRepository.findById(id).orElseThrow();
        Client client = this.clientRestClient.findClientById(product.getClientId());
        product.setClient(client);
        return product;
    }
}