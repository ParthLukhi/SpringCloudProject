package com.humber.customer.controller;

import com.humber.customer.records.CustomerRequest;
import com.humber.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("New Registration.", customerRequest);
        customerService.registerCustomer(customerRequest);

    }
}
