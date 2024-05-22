package com.example.rabbitmqapplication.rabbitmq;

import com.example.rabbitmqapplication.model.CalculationRequest;
import com.example.rabbitmqapplication.service.CalculationService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "calculation.requests")
public class CalculationRequestConsumer {

    @Autowired
    private CalculationService calculationService;

    @RabbitHandler
    public void handleCalculationRequest(CalculationRequest request) {
        calculationService.addNumbers(request.getNumber1(), request.getNumber2());
    }
}
