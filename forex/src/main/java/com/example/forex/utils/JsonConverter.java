package com.example.forex.utils;

import com.example.forex.model.ExchangeRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonConverter {

    public static ExchangeRate fromJson(String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(json);
        JsonNode exchangeRateNode = rootNode.get("Realtime Currency Exchange Rate");
        String resultJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(exchangeRateNode);
        ExchangeRate exchangeRate = objectMapper.readValue(resultJson, ExchangeRate.class);
        log.info("Exchange rate: {}", exchangeRate);
        return exchangeRate;
    }
}
