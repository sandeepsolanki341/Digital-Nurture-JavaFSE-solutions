package com.cognizant.springlearn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Doc 1 HO4: loaded from country.xml. Doc 4: bean validation for POST.
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("getCode");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode");
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("getName");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
