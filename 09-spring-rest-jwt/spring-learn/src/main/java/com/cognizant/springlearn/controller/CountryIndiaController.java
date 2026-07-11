package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Doc 2: early "/country" service returning the India bean loaded from country.xml,
 * kept separate from the resource-oriented "/countries" controller (Doc 4 convention).
 */
@RestController
public class CountryIndiaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryIndiaController.class);

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        LOGGER.info("End");
        return country;
    }
}
