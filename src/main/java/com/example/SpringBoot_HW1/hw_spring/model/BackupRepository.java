package com.example.SpringBoot_HW1.hw_spring.model;

import com.example.SpringBoot_HW1.hw_spring.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class BackupRepository implements Repository {
    @Override
    public void save() {
        System.out.println("Saving in Data in BackupRepository!");
    }
}
