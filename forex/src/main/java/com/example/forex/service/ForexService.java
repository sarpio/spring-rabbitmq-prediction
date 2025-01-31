package com.example.forex.service;

import com.example.forex.model.ExchangeRate;
import com.example.forex.publisher.ForexProducer;
import com.example.forex.utils.JsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Service
@RequiredArgsConstructor
public class ForexService {


    @Value("${forex.function}")
    private String function;

    @Value("${forex.from-currency}")
    private String fromCurrency;

    @Value("${forex.to-currency}")
    private String toCurrency;

    @Value("${forex.api-key}")
    private String apiKey;

    private final WebClient webClient;
    private final ForexProducer forexProducer;

    public ExchangeRate getExchangeRate() throws JsonProcessingException {
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query?")
                        .queryParam("function", function)
                        .queryParam("from_currency", fromCurrency)
                        .queryParam("to_currency", toCurrency)
                        .queryParam("apikey", apiKey)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (response!=null && response.contains("Error Message")) {
            log.error(response);
        } else {
            return JsonConverter.fromJson(response);
        }
        return new ExchangeRate();
    }

    @Scheduled(cron = "${scheduler.cron}")
    void publishForexData() {
        try {
        forexProducer.sendForexExchangeRate(getExchangeRate());
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
