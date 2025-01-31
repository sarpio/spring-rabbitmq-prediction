package com.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse  {

    private String locationName;
    private String locationCountry;
    private LocalDateTime lastUpdate;
    private double tempC;
}
