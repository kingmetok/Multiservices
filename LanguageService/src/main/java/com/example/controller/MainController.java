package com.example.controller;

import com.example.team.entity.Language;
import com.example.team.feign.LanguageServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class MainController {

    @GetMapping
    public List<Language> getTeams() {
        return LanguageServiceFeignClient.FeignHolder.create().getAllTeams();
    }
}
