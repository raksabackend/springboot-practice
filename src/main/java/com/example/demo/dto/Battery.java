package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class Battery {
    public void supplyPower() {
        System.out.println("Battery Power");
    }
}
