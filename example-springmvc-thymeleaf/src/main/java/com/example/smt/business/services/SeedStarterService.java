package com.example.smt.business.services;

import com.example.smt.business.entities.SeedStarter;
import com.example.smt.business.repositories.SeedStarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedStarterService {
    
    @Autowired
    private SeedStarterRepository seedstarterRepository;

    public SeedStarterService() {
        super();
    }

    public List<SeedStarter> findAll() {
        return this.seedstarterRepository.findAll();
    }

    public void add(final SeedStarter seedStarter) {
        this.seedstarterRepository.add(seedStarter);
    }
    
}
