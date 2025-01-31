package com.example.forex.publisher;

import com.example.forex.model.ExchangeRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ForexProducer {

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.routing-key}")
    private String key;

    private final RabbitTemplate rabbitTemplate;

    public void sendForexExchangeRate(ExchangeRate weather) {
        try {
            rabbitTemplate.convertAndSend(exchangeName, key, weather);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
