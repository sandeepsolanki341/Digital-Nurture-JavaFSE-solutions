package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDao {

    private static List<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        countryList = (ArrayList<Country>) context.getBean("countryList");
    }

    public List<Country> getAllCountries() {
        return countryList;
    }
}
