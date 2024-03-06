package com.example.SpringBoot_HW1.own_ioc;

import com.example.SpringBoot_HW1.own_ioc.container.ApplicationContext;
import com.example.SpringBoot_HW1.own_ioc.model.Car;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ApplicationContext("com.example.SpringBoot_HW1.own_ioc.model");
        Car car = context.getBean(Car.class);
        car.drive();
    }
}
