package com.example.fueltracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fuel_entries")
public class FuelEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "distance")
    private double distance;

    @Column(name = "liters")
    private double liters;

    @Column(name = "date")
    private Date date;

    // Constructors, getters and setters

    public FuelEntry() {
    }

    public FuelEntry(double distance, double liters, Date date) {
        this.distance = distance;
        this.liters = liters;
        this.date = date;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

