package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import com.example.weather.publisher.WeatherProducer;
import com.example.weather.utils.JsonConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherDataService {

    @Value("${weather.key}")
    private String key;

    @Value("${weather.city}")
    private String city;

    @Value("${weather.days}")
    private String days;

    private final WebClient webClient;
    private final WeatherProducer weatherProducer;

    public WeatherResponse getWeatherData() {
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("key", this.key)
                        .queryParam("q", this.city)
                        .queryParam("days", this.days)
                        .build()
                ).retrieve()
                .bodyToMono(String.class)
                .block();
        if (response != null && response.contains("Error Message")) {
            log.error(response);
        } else {
            return JsonConverter.fromJson(response);
        }
        return new WeatherResponse();
    }

    @Scheduled(cron = "${scheduler.cron}")
    void publishWeatherData() {
        WeatherResponse weatherData = getWeatherData();
        weatherProducer.sendWeather(weatherData);
    }
}
