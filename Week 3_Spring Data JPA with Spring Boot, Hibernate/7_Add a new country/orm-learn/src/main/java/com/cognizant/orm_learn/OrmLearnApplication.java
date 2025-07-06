package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        testAddCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start - Add Country");

        Country newCountry = new Country();
        newCountry.setCode("XX");
        newCountry.setName("Test");

        countryService.addCountry(newCountry);

        try {
            Country fetchedCountry = countryService.findCountryByCode("FR");
            LOGGER.debug("Added Country: {}", fetchedCountry);
        } catch (Exception e) {
            LOGGER.error("Error fetching country after add: {}", e.getMessage());
        }

        LOGGER.info("End - Add Country");
    }
}
