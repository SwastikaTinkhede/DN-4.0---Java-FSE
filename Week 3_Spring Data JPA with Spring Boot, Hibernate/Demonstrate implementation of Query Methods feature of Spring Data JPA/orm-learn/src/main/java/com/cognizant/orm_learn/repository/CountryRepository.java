package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Countries where name contains given text (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String name);

    // 2. Same as above, but ordered alphabetically
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    // 3. Countries starting with a given letter (case-insensitive)
    List<Country> findByNameStartingWithIgnoreCase(String prefix);
}
