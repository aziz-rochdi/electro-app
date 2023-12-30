package com.rochdi.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
