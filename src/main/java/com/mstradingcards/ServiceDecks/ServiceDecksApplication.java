package com.mstradingcards.ServiceDecks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.mstradingcards.ServiceDecks"})
@EntityScan("com.mstradingcards.ServiceDecks.models")
@EnableJpaRepositories("com.mstradingcards.ServiceDecks.repository")
public class ServiceDecksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDecksApplication.class, args);
	}

}
