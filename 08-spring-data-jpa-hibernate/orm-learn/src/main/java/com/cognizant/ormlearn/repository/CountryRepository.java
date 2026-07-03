package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Doc 2, Hands-on 1: search by containing text, ordered ascending.
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // Doc 2, Hands-on 1: countries starting with a given letter.
    List<Country> findByNameStartingWith(String prefix);
}
