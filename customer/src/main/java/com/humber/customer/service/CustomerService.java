package com.humber.customer.service;

import com.humber.customer.model.Customer;
import com.humber.customer.records.CustomerRequest;
import com.humber.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        customerRepository.save(customer);
    }
}
