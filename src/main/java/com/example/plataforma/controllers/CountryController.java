package com.example.plataforma.controllers;

import com.example.plataforma.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

}
