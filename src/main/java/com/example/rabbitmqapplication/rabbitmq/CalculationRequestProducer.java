package com.example.rabbitmqapplication.rabbitmq;

import com.example.rabbitmqapplication.model.CalculationRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculationRequestProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCalculationRequest(CalculationRequest request) {
        rabbitTemplate.convertAndSend("calculation.requests", request);
    }
}
