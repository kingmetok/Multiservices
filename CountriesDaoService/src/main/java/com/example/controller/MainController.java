package com.example.controller;

import com.example.entity.Country;
import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class MainController {

    private CountryRepository countryRepository;

    @Autowired
    public MainController(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public Iterable<Country> getCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Long id) {
        return countryRepository.findAllById(id);
    }
}
