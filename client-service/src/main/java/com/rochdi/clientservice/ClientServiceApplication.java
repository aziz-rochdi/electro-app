package com.rochdi.clientservice;

import com.rochdi.clientservice.config.GlobalConfig;
import com.rochdi.clientservice.entities.Client;
import com.rochdi.clientservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
		return args -> {
			List<Client> clients = List.of(
					Client.builder()
							.firstName("test1")
							.lastName("test1")
							.email("test1@gmail.com")
							.phone("+212611223344")
							.build(),
					Client.builder()
							.firstName("test2")
							.lastName("test2")
							.email("test2@gmail.com")
							.phone("+212611223344")
							.build()
			);
			clientRepository.saveAll(clients);
		};
	}

}
