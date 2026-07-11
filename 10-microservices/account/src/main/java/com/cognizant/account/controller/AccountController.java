package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// GET /accounts/{number} -> dummy account, no backend.
@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        LOGGER.info("Start - get account {}", number);
        return new Account(number, "savings", 234343);
    }
}
