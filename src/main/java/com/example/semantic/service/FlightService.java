package com.example.semantic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Service
public class FlightService {
    private final String apiKey = "5d90e38e40msh30263df306dbde8p16b0c5jsnd04503896e61";
    private final String rapidApiHost = "booking-com15.p.rapidapi.com";
    private final String baseUrl = "https://booking-com15.p.rapidapi.com/api/v1/flights/getMinPrice";

    public String getMinFlightPrice(String fromId, String toId, String departDate, String currencyCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("fromId", fromId)
                .queryParam("toId", toId)
                .queryParam("departDate", departDate)
                .queryParam("currency_code", currencyCode);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }}