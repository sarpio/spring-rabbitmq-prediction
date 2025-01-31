package com.example.agregator.rest;

import com.example.agregator.model.ExchangeRateEntity;
import com.example.agregator.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final PredictionService predictionService;

    @GetMapping("/stats")
    public ResponseEntity<List<ExchangeRateEntity>>getExchangeRateStats() {
        return ResponseEntity.ok(predictionService.showExchangeRateStats());
    }
}
