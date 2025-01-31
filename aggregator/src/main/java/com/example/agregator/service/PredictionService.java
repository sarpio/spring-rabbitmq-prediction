package com.example.agregator.service;

import com.example.agregator.model.ExchangeRateEntity;
import com.example.agregator.model.TemperatureEntity;
import com.example.agregator.repo.ExchangeRateRepository;
import com.example.agregator.repo.TemperatureEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PredictionService {

    @Value("${history.size}")
    private int HISTORY_SIZE;

    private final TemperatureEntityRepository temperatureRepository;
    private final ExchangeRateRepository exchangeRepository;

    public List<TemperatureEntity> showTemperatureStats() {
        return temperatureRepository.findLast25Records();
    }

    public List<ExchangeRateEntity> showExchangeRateStats() {
        return exchangeRepository.findLast25Records();
    }

        public void temperatureData(TemperatureEntity temperatureEntity) {
        Queue<Double> top10Temperature = new LinkedList<>(
                temperatureRepository.findTop10ByOrderByIdDesc()
                        .stream()
                        .map(TemperatureEntity::getTemperature)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            Collections.reverse(list);
                                            return list;
                                        }
                                )
                        )
        );
        temperatureEntity.setTemperatureForecast(predictNextValue(top10Temperature));
        temperatureRepository.save(temperatureEntity);
    }


    public void forexData(ExchangeRateEntity entity) {
        Queue<Double> top10ExchangeRate = new LinkedList<>(
                exchangeRepository.findTop10ByOrderByIdDesc()
                        .stream()
                        .map(ExchangeRateEntity::getRate)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            Collections.reverse(list);
                                            return list;
                                        }
                                )
                        )
        );
        entity.setForecastRate(predictNextValue(top10ExchangeRate));
        exchangeRepository.save(entity);
    }

    private double predictNextValue(Queue<Double> values) {
        if (values.size() < HISTORY_SIZE) {
            return 0.0;
        }
        SimpleRegression regression = new SimpleRegression(true);
        int counter = 1;
        for (Double value : values) {
            regression.addData(counter++, value);
        }
        double predict = regression.predict(HISTORY_SIZE + 1);
        return Math.round(predict * 100.0) / 100.0;
    }
}
