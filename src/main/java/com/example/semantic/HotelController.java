package com.example.semantic;

import com.example.semantic.model.Flight;
import com.example.semantic.model.Hotel;
import com.example.semantic.repository.FlightRepository;
import com.example.semantic.repository.HotelRepository;
import com.example.semantic.service.HotelsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {
    private final HotelsService hotelService;
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    public HotelController(HotelsService hotelService, HotelRepository hotelRepository) {
        this.hotelService = hotelService;
        this.hotelRepository = hotelRepository;
    }
    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/search")
    public ResponseEntity<String> searchHotels(
            @RequestParam("arrivalDate") String arrivalDate,
            @RequestParam("departureDate") String departureDate,
            @RequestParam("adults") Number adults,
            @RequestParam("roomQty") Number roomQty
    ) {
        return hotelService.searchHotels(arrivalDate, departureDate, adults, roomQty);
    }

    @PostMapping("/add")
    public Long createUser(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
        LOGGER.info(String.valueOf(hotel.getId()));
        return hotel.getId();
    }

    @GetMapping("/hotel/{userId}")
    public Hotel getFlightsByUserId(@PathVariable Long userId) {
        return hotelRepository.findByUserId(userId);
    }
}
