package com.example.controller;

import com.example.entity.Language;
import com.example.feign.LanguageServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @GetMapping
    public List<Language> getLanguages() {
        return LanguageServiceFeignClient.FeignHolder.create().getAllLanguages();
    }
}
