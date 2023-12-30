package com.rochdi.productservice.entities;

import com.rochdi.productservice.models.Client;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected LocalDateTime creationDate;
    protected LocalDateTime editionDate;
    private String name;
    private String description;
    private String imageUrl;
    private Long clientId;
    @Transient
    private Client client;

    @PrePersist
    protected void onPersist() {
        this.creationDate = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.editionDate = LocalDateTime.now();
    }
}
