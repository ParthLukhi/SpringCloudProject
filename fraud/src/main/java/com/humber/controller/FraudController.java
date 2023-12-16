package com.humber.controller;

import com.humber.response.FraudResponse;
import com.humber.service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/fraud-check")
public class FraudController {

    private final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping(path = "{id}")
    public FraudResponse isFraud(@PathVariable("id") int customerId){
        boolean isFraudCustomer = fraudService.isFraudCustomer(customerId);
        log.info("Fraud check request for customer{}", customerId);

        return new FraudResponse(isFraudCustomer);
    }
}
