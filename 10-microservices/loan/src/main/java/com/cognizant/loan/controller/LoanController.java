package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// GET /loans/{number} -> dummy loan, no backend.
@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        LOGGER.info("Start - get loan {}", number);
        return new Loan(number, "car", 400000, 3258, 18);
    }
}
