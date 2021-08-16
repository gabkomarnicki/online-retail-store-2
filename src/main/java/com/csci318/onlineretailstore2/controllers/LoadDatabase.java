package com.csci318.onlineretailstore2.controllers;

import com.csci318.onlineretailstore2.models.Customer;
import com.csci318.onlineretailstore2.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDB(CustomerRepository repository) {
        return args -> {
            log.info("Loading... " + repository.save(new Customer("ABC Company", "221B Baker St", "United Kingdom")));
            log.info("Loading... " + repository.save(new Customer("DEF Company", "742 Evergreen Terrace", "United States of America")));
        };
    }
}
