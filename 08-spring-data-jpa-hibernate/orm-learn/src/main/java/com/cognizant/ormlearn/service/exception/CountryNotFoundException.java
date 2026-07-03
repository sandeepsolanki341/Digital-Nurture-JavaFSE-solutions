package com.cognizant.ormlearn.service.exception;

// Doc 1, Hands-on 6.
public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(String message) {
        super(message);
    }
}
