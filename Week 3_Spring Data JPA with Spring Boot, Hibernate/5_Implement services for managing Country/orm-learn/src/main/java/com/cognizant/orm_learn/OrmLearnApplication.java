package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testAddCountry();
        testFindCountryByCode();
        testUpdateCountry();
        testFindCountryByCode(); // Verify update
        testFindCountriesByPartialName();
        testDeleteCountry();
        testFindCountryByCode(); // Verify deletion
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start - Get All Countries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End - Get All Countries");
    }

    private static void testAddCountry() {
        LOGGER.info("Start - Add Country");
        Country country = new Country();
        country.setCode("JP");
        country.setName("Japan");
        countryService.addCountry(country);
        LOGGER.debug("Added country={}", country);
        LOGGER.info("End - Add Country");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start - Find Country by Code");
        try {
            Country country = countryService.findCountryByCode("JP");
            LOGGER.debug("Country: {}", country);
        } catch (Exception e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("End - Find Country by Code");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start - Update Country");
        Country country = new Country();
        country.setCode("JP");
        country.setName("Japan Updated");
        countryService.updateCountry(country);
        LOGGER.debug("Updated country={}", country);
        LOGGER.info("End - Update Country");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start - Delete Country");
        countryService.deleteCountry("JP");
        LOGGER.debug("Deleted country with code=JP");
        LOGGER.info("End - Delete Country");
    }

    private static void testFindCountriesByPartialName() {
        LOGGER.info("Start - Find Countries by Partial Name");
        List<Country> countries = countryService.searchCountriesByName("an");
        LOGGER.debug("Countries with 'an' in name={}", countries);
        LOGGER.info("End - Find Countries by Partial Name");
    }
}
