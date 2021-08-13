package com.csci318.onlineretailstore2;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {

    private final CustomerRepository repository;
    private final CustomerModelAssembler assembler;

    public CustomerController(CustomerRepository repository, CustomerModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/customers")
    CollectionModel<EntityModel<Customer>> all() {

        List<EntityModel<Customer>> customers = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(customers,
        linkTo(methodOn(CustomerController.class).all()).withSelfRel());
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @GetMapping("/customers/{id}")
    EntityModel<Customer> one(@PathVariable Long id) {

        Customer customer = repository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));

        return assembler.toModel(customer);
    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer,
                             @PathVariable Long id) {
        return repository.findById(id)
                .map(customer -> {
                    customer.setCompanyName(newCustomer.getCompanyName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setCountry(newCustomer.getCountry());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
