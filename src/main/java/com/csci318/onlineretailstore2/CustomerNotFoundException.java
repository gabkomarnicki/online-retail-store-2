package com.csci318.onlineretailstore2;

public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(Long id) {
        super("Customer " + id + " cannot be found.");
    }
}
