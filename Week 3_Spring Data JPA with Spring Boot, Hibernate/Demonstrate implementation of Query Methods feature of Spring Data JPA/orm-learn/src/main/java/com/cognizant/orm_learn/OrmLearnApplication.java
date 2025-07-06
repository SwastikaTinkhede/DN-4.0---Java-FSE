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
        countryService = context.getBean(CountryService.class);

        testSearchByPartialName();
        testSearchByPartialNameSorted();
        testSearchByAlphabet("Z");
    }

    private static void testSearchByPartialName() {
        LOGGER.info("Search by partial name:");
        List<Country> countries = countryService.searchCountriesByName("ou");
        countries.forEach(country -> LOGGER.debug("Code: {}, Name: {}", country.getCode(), country.getName()));
    }

    private static void testSearchByPartialNameSorted() {
        LOGGER.info("Search by partial name with ascending sort:");
        List<Country> countries = countryService.searchCountriesByNameSorted("ou");
        countries.forEach(country -> LOGGER.debug("Code: {}, Name: {}", country.getCode(), country.getName()));
    }

    private static void testSearchByAlphabet(String letter) {
        LOGGER.info("Search countries starting with '{}':", letter);
        List<Country> countries = countryService.getCountriesStartingWith(letter);
        countries.forEach(country -> LOGGER.debug("Code: {}, Name: {}", country.getCode(), country.getName()));
    }
}
