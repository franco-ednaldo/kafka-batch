package com.example.kafkabatch.service;

import com.example.kafkabatch.model.entity.Customer;
import com.example.kafkabatch.model.repository.CustomerRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {
    private final CustomerRepository customerRepository;

    private final MongoTemplate mongoTemplate;

    public CustomerService(CustomerRepository customerRepository, MongoTemplate mongoTemplate) {
        this.customerRepository = customerRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Customer save(final Customer customer) {
        return this.customerRepository.save(customer);
    }
    public List<Customer> save(final List<Customer> customer) {
        return this.customerRepository.saveAll(customer);
    }
}
