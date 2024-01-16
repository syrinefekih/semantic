package com.example.semantic;

import com.example.semantic.model.ResourceConfirmation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")

public class ResourceConfirmationController {
    @PostMapping("/confirmResource")
    public ResponseEntity<ResourceConfirmation> confirmResource(@RequestBody ResourceConfirmation confirmation) {
        // Access the received data
        String surfaceForm = confirmation.getSurfaceForm();
        String arrivalDate = confirmation.getArrivalDate();
        String departureDate = confirmation.getDepartureDate();

        ResourceConfirmation confirmedResource = new ResourceConfirmation(surfaceForm, arrivalDate, departureDate);

        return ResponseEntity.ok(confirmedResource);
    }}
