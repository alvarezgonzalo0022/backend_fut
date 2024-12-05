package com.apiFootballFormatter.repository;

import com.apiFootballFormatter.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByname(String name);

}
