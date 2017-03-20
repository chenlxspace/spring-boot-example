package com.example.smt.business.services;

import com.example.smt.business.entities.Variety;
import com.example.smt.business.repositories.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietyService {
    
    @Autowired
    private VarietyRepository varietyRepository;

    public VarietyService() {
        super();
    }

    public List<Variety> findAll() {
        return this.varietyRepository.findAll();
    }

    public Variety findById(final Integer id) {
        return this.varietyRepository.findById(id);
    }
    
}
