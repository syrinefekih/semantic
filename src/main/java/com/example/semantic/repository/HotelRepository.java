package com.example.semantic.repository;

import com.example.semantic.model.Flight;
import com.example.semantic.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByUserId(Long userId);
}