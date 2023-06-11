package com.example.fueltracker.repository;

import com.example.fueltracker.model.FuelEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelEntryRepository extends JpaRepository<FuelEntry, Long> {
    FuelEntry findTopByOrderByDateDesc();
}