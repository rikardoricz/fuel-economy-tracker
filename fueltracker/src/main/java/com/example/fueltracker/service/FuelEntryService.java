package com.example.fueltracker.service;

import com.example.fueltracker.model.FuelEntry;
import com.example.fueltracker.repository.FuelEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelEntryService {
    private final FuelEntryRepository fuelEntryRepository;

    @Autowired
    public FuelEntryService(FuelEntryRepository fuelEntryRepository) {
        this.fuelEntryRepository = fuelEntryRepository;
    }

    public FuelEntry saveFuelEntry(FuelEntry fuelEntry) {
        return fuelEntryRepository.save(fuelEntry);
    }

    public double calculateAverageFuelConsumption() {
        FuelEntry lastEntry = fuelEntryRepository.findTopByOrderByDateDesc();
        if (lastEntry == null || lastEntry.getDistance() == 0) {
            return 0.0;
        }
        return (lastEntry.getLiters() / lastEntry.getDistance()) * 100;
    }

    public List<FuelEntry> getAllFuelEntries() {
        return fuelEntryRepository.findAll();
    }
}
