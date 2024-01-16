package com.example.semantic.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class HotelsService {
    private final String apiKey = "a9f19458ecmsh50a37547ae40a50p1a5535jsn2f16b378054e";
    private final String rapidApiHost = "booking-com15.p.rapidapi.com";
    private final String baseUrl = "https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels";

    public ResponseEntity<String> searchHotels(String arrivalDate, String departureDate, Number adults, Number roomQty) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("dest_id", "-2092174")
                .queryParam("search_type", "CITY")
                .queryParam("arrival_date", arrivalDate)
                .queryParam("departure_date", departureDate)
                .queryParam("adults", adults)
                .queryParam("children_age", "0,17")
                .queryParam("room_qty", roomQty)
                .queryParam("page_number", "1")
                .queryParam("languagecode", "en-us")
                .queryParam("currency_code", "AED");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response;
    }
}
