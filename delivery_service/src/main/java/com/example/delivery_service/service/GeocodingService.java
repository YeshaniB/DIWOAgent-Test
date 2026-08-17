package com.example.delivery_service.service;

import com.example.delivery_service.model.Location;
//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeocodingService {

    @Value("${google.maps.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GeocodingService(@Qualifier("restTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Location geocodeAddress(String address) {
        try {
            URI uri = UriComponentsBuilder
                    .fromUriString("https://maps.googleapis.com/maps/api/geocode/json")
                    .queryParam("address", address)
                    .queryParam("key", apiKey)
                    .build()
                    .toUri();

            Map<String, Object> response = restTemplate.getForObject(uri, HashMap.class);

            if (response != null && response.containsKey("results")) {
                Map<String, Object> result = ((List<Map<String, Object>>) response.get("results")).get(0);
                Map<String, Object> location = (Map<String, Object>) ((Map<String, Object>) result.get("geometry")).get("location");

                return new Location(
                        (Double) location.get("lat"),
                        (Double) location.get("lng")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to geocode address: " + address, e);
        }
        throw new RuntimeException("No results found for address: " + address);
    }
}
