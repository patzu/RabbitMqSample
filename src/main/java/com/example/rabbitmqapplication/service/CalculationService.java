package com.example.rabbitmqapplication.service;

import com.example.rabbitmqapplication.repository.CalculationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CalculationService {

    CalculationResultRepository calculationResultRepository;

    @Autowired
    public CalculationService(CalculationResultRepository calculationResultRepository) {
        this.calculationResultRepository = calculationResultRepository;
    }

    private final AtomicLong idGenerator = new AtomicLong(0);

    public int addNumbers(int number1, int number2) {
        int result = number1 + number2;
        long calculationId = idGenerator.incrementAndGet();
        calculationResultRepository.saveCalculationResult(calculationId, result);
        return result;
    }
}
