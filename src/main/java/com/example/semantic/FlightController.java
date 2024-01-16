package com.example.semantic;
import com.example.semantic.model.Flight;
import com.example.semantic.model.User;
import com.example.semantic.repository.FlightRepository;
import com.example.semantic.service.FlightService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:4200")

public class FlightController {
    @Autowired
    private final FlightService flightService;
    @Autowired
    private final FlightRepository flightRepository;

    public FlightController(FlightService flightService, FlightRepository flightRepository) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }
    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @GetMapping("/getMinFlightPrice")
    public ResponseEntity<String> getMinFlightPrice(
            @RequestParam("fromId") String fromId,
            @RequestParam("toId") String toId,
            @RequestParam("departDate") String departDate,
            @RequestParam(value = "currencyCode", defaultValue = "AED") String currencyCode
    ) {
        String result = flightService.getMinFlightPrice(fromId, toId, departDate, currencyCode);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public Long createUser(@RequestBody Flight flight) {
        flightRepository.save(flight);
        LOGGER.info(String.valueOf(flight.getId()));
        return flight.getId();
    }

    @GetMapping("/flight/{userId}")
    public Flight getFlightsByUserId(@PathVariable Long userId) {
        return flightRepository.findByUserId(userId);
    }
}