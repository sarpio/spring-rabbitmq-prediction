package com.example.forex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    @JsonProperty("1. From_Currency Code")
    private String fromCurrencyCode;

    @JsonProperty("3. To_Currency Code")
    private String toCurrencyCode;

    @JsonProperty("5. Exchange Rate")
    private String exchangeRate;

    @JsonProperty("6. Last Refreshed")
    private String lastRefreshed;
}
