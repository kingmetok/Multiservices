package com.example.controller;

import com.example.entity.Language;
import com.example.repository.LanguageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/language")
public class MainController {

    private LanguageDao languageDao;

    @Autowired
    public MainController(final LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @GetMapping
    public Iterable<Language> getLanguages() {
        return languageDao.findAll();
    }
}
