package com.example.agregator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "temperature")
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String locationName;
    private String locationCountry;
    private LocalDateTime lastUpdate;
    private double temperature;
    private double temperatureForecast;
}
