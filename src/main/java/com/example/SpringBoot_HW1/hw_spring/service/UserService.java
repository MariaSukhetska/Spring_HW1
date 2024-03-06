package com.example.SpringBoot_HW1.hw_spring.service;

import com.example.SpringBoot_HW1.hw_spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Repository repository;

    @Autowired
    public UserService(@Qualifier("dataRepository") Repository repository) {
        this.repository = repository;
    }

    public void useRepository() {
        repository.save();
    }
}
