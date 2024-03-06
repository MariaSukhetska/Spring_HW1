package com.example.SpringBoot_HW1.hw_spring;

import com.example.SpringBoot_HW1.hw_spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("repositoryConfig.xml");
        UserService userService = context.getBean(UserService.class);
        userService.useRepository();
        context.close();
    }
}
