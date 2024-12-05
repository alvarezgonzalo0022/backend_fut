package com.apiFootballFormatter.service;

import com.apiFootballFormatter.model.Country;
import com.apiFootballFormatter.model.Player;
import com.apiFootballFormatter.model.dto.CountryDto;
import com.apiFootballFormatter.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    public Country save(Country country) {
        Optional<Country> countryOptional = countryRepository.findByname(country.getName());
        if (countryOptional.isPresent()) {
            return countryOptional.get();
        }
        return countryRepository.save(country);
    }

    public List<Country> saveAll(List<CountryDto> countries) {
        for (CountryDto country : countries) {
            Country countryToSave = new Country(country.getName(), country.getFlag(), country.getCode());
            save(countryToSave);
        }
        return listAll();
    }

    public Country getById(Long id){
        return countryRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        countryRepository.deleteById(id);
    }

}
