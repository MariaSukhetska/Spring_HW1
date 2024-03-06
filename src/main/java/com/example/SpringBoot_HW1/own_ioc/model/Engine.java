package com.example.SpringBoot_HW1.own_ioc.model;

import com.example.SpringBoot_HW1.own_ioc.annotation.Component;
import lombok.Getter;

@Getter
@Component
public class Engine {
    private final String type;

    public Engine() {
        this.type = "V8";
    }
}
