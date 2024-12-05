package com.apiFootballFormatter.controller;

import com.apiFootballFormatter.model.Country;
import com.apiFootballFormatter.model.dto.CountryDto;
import com.apiFootballFormatter.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public List<Country> getCountries(){
        return countryService.listAll();
    }

    @PostMapping("/all")
    public List<Country> saveAllCountries(@RequestBody List<CountryDto> countries) throws Exception {
        return countryService.saveAll(countries);
    }


}
