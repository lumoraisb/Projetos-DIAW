package com.example.Atividade_Metereologia.controller;

import com.example.Atividade_Metereologia.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final WeatherService weatherService;

    public Controller(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/clima")
    public String verClima() {
        double latitude = -19.92;
        double longitude = -43.94;
        return weatherService.preverTempo(latitude, longitude);
    }
}