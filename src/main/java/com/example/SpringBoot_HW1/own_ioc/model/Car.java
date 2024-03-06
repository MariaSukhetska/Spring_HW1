package com.example.SpringBoot_HW1.own_ioc.model;

import com.example.SpringBoot_HW1.own_ioc.annotation.Component;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Car {
    private final Engine engine;
    public void drive() {
        System.out.println("Car is driving with " + engine.getType() + " engine");
    }

}
