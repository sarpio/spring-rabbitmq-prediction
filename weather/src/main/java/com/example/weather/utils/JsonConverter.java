package com.example.weather.utils;

import com.example.weather.model.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;

public class JsonConverter {

    public static WeatherResponse fromJson(String json) {
        Gson gson = new Gson();

        // Parsing the JSON into a JsonObject to handle nested fields manually if necessary
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Extracting the location and current fields manually
        String locationName = jsonObject.getAsJsonObject("location").get("name").getAsString();
        String locationCountry = jsonObject.getAsJsonObject("location").get("country").getAsString();
        String lastUpdatedStr = jsonObject.getAsJsonObject("current").get("last_updated").getAsString();
        double tempC = jsonObject.getAsJsonObject("current").get("temp_c").getAsDouble();

        // Parsing the date manually using the given format
        LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdatedStr.replace(" ", "T"));

        // Creating a WeatherData object
        WeatherResponse response = new WeatherResponse();
        response.setLocationName(locationName);
        response.setLastUpdate(lastUpdate);
        response.setTempC(tempC);
        response.setLocationCountry(locationCountry);

        return response;
    }

}
