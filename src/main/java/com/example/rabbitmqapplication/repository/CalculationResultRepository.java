package com.example.rabbitmqapplication.repository;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CalculationResultRepository {

    // In-memory database to store calculation results
    private ConcurrentHashMap<Long, Integer> calculationResults = new ConcurrentHashMap<>();

    public void saveCalculationResult(Long calculationId, Integer result) {
        calculationResults.put(calculationId, result);
    }
}
