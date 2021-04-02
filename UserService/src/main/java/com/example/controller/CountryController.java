package com.example.controller;

import com.example.entity.Country;
import com.example.feign.CountryServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @GetMapping
    public List<Country> getCountries() {
        return CountryServiceFeignClient.FeignHolder.create().getCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") long id) {
        return CountryServiceFeignClient.FeignHolder.create().getCountry(id);
    }
}
