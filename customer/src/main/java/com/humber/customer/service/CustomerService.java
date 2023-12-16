package com.humber.customer.service;

import com.humber.customer.config.CustomerConfig;
import com.humber.customer.model.Customer;
import com.humber.customer.records.CustomerRequest;
import com.humber.customer.repository.CustomerRepository;
import com.humber.customer.response.FraudResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudResponse fraudResponse = restTemplate.getForObject(
                "http://localhost:8081/api/fraud-check/{id}",
                FraudResponse.class,
                customer.getId()
        );

        if (fraudResponse.isFraud()){
            throw new IllegalStateException("Please don make fraud entry.");
        }

    }
}
