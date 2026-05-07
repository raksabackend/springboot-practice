package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class Phone {

    private final Battery battery;

    public Phone(Battery battery){
        this.battery = battery;
    };

    /**
     * Spring already manages battery bean. We inject the battery bean dependency into the Phone class.
     */

    public void turnOn() {
        battery.supplyPower();
        System.out.println("Phone on");
    }

    /**
     *
     * The main thing you must understand.
     * Not annotations.
     * Not syntax.
     * Understand this sentence :
     * Spring automatically creates objects and connects them together.
     * That is the core idea behind IoC and DI.
     **/
}
