package com.example.weather.publisher;

import com.example.weather.model.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherProducer {

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.routing-key}")
    private String key;

    private final RabbitTemplate rabbitTemplate;

    public void sendWeather(WeatherResponse weather) {
        log.info("Sending weather to RabbitMQ: {}", weather);
        rabbitTemplate.convertAndSend(exchangeName, key, weather);
    }
}
