package com.example.agregator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("1. From_Currency Code")
    private String fromCurrencyCode;

    @JsonProperty("3. To_Currency Code")
    private String toCurrencyCode;

    @JsonProperty("5. Exchange Rate")
    private double exchangeRate;

    @JsonProperty("6. Last Refreshed")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastRefreshed;
}
