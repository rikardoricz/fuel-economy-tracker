package com.example.fueltracker.controller;

import com.example.fueltracker.model.FuelEntry;
import com.example.fueltracker.service.FuelEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fuel-entries")
public class FuelEntryController {
    private final FuelEntryService fuelEntryService;

    @Autowired
    public FuelEntryController(FuelEntryService fuelEntryService) {
        this.fuelEntryService = fuelEntryService;
    }

//    @GetMapping
//    public ResponseEntity<List<FuelEntry>> getAllFuelEntries() {
//        List<FuelEntry> fuelEntries = fuelEntryService.getAllFuelEntries();
//        return ResponseEntity.ok(fuelEntries);
//    }
    @CrossOrigin
    @GetMapping
    public List<FuelEntry> getAllFuelEntries() {
        return fuelEntryService.getAllFuelEntries();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<FuelEntry> saveFuelEntry(@RequestBody FuelEntry fuelEntry) {
        FuelEntry savedEntry = fuelEntryService.saveFuelEntry(fuelEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntry);
    }

    @CrossOrigin
    @GetMapping("/average-fuel-consumption")
    public ResponseEntity<Double> calculateAverageFuelConsumption() {
        double averageFuelConsumption = fuelEntryService.calculateAverageFuelConsumption();
        return ResponseEntity.ok(averageFuelConsumption);
    }
}
