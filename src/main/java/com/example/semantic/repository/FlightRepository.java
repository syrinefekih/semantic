package com.example.semantic.repository;

import com.example.semantic.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByUserId(Long userId);
}
