package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Driver for all Spring Data JPA / Hibernate hands-on exercises.
 * Uncomment the relevant test call in main() to exercise a given feature.
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllCountries();
        // testFindCountryByCode();
        // testAddCountry();
        // testUpdateCountry();
        // testDeleteCountry();
        // testGetAllPermanentEmployees();
        // testGetAverageSalary();
    }

    // Doc 1, Hands-on 1
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    // Doc 1, Hands-on 6
    private static void testFindCountryByCode() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("End");
    }

    // Doc 1, Hands-on 7
    private static void testAddCountry() {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("XX");
        country.setName("Xanadu");
        countryService.addCountry(country);
        LOGGER.info("End");
    }

    // Doc 1, Hands-on 8
    private static void testUpdateCountry() {
        LOGGER.info("Start");
        countryService.updateCountry("XX", "Xanadu Republic");
        LOGGER.info("End");
    }

    // Doc 1, Hands-on 9
    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("XX");
        LOGGER.info("End");
    }

    // Doc 3, Hands-on 2
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    // Doc 3, Hands-on 4
    private static void testGetAverageSalary() {
        LOGGER.info("Start");
        LOGGER.debug("Average salary (dept 1):{}", employeeService.getAverageSalary(1));
        LOGGER.info("End");
    }
}
