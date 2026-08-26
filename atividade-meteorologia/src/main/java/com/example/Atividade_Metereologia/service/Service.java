package com.example.Atividade_Metereologia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${climatempo.api.url}")
    private String apiUrl;

    public String preverTempo(double latitude, double longitude) {

        String urlFinal = apiUrl
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current=is_day,relative_humidity_2m"
                + "&hourly=temperature_2m,relative_humidity_2m,visibility"
                + "&daily=uv_index_max"
                + "&timezone=auto";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlFinal, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return "Falha ao obter dados meteorológicos. Código: " + responseEntity.getStatusCode();
        }
    }
}