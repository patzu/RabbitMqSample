package com.example.rabbitmqapplication.controller;

import com.example.rabbitmqapplication.model.CalculationRequest;
import com.example.rabbitmqapplication.rabbitmq.CalculationRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    @Autowired
    private CalculationRequestProducer requestProducer;

    @PostMapping("/calculate")
    public void calculate(@RequestBody CalculationRequest request) {
        requestProducer.sendCalculationRequest(request);
    }
}

