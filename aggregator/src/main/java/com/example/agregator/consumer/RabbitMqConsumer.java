package com.example.agregator.consumer;

import com.example.agregator.model.ExchangeRate;
import com.example.agregator.model.ExchangeRateEntity;
import com.example.agregator.model.TemperatureEntity;
import com.example.agregator.model.WeatherResponse;
import com.example.agregator.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RabbitMqConsumer {

    private final PredictionService predictionService;

    @RabbitListener(queues = "${rabbitmq.weather-queue}")
    public void weatherDataConsumer(WeatherResponse weatherData) {
        TemperatureEntity temperatureEntity = new TemperatureEntity();
        temperatureEntity.setTemperature(weatherData.getTempC());
        temperatureEntity.setLastUpdate(weatherData.getLastUpdate());
        temperatureEntity.setLocationName(weatherData.getLocationName());
        temperatureEntity.setLocationCountry(weatherData.getLocationCountry());
        temperatureEntity.setTemperatureForecast(0);
        predictionService.temperatureData(temperatureEntity);
    }

    @RabbitListener(queues = "${rabbitmq.forex-queue}")
    public void forexDataConsumer(ExchangeRate exchangeRate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setCurrency(exchangeRate.getFromCurrencyCode());
        exchangeRateEntity.setRate(exchangeRate.getExchangeRate());
        exchangeRateEntity.setExchange(exchangeRate.getLastRefreshed());
        exchangeRateEntity.setForecastRate(0);
        predictionService.forexData(exchangeRateEntity);
    }
}
