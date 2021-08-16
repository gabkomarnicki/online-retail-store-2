package com.csci318.onlineretailstore2.repositories;

import com.csci318.onlineretailstore2.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
