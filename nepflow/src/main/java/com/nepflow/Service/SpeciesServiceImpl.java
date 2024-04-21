package com.nepflow.Service;

import com.nepflow.Models.Species;
import com.nepflow.Repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    @Autowired
    SpeciesRepository speciesRepository;


    @Override
    public boolean createNewSpecies(String name) {
        Species species = this.getSpecies(name);
        if (species != null) {
            return false;
        }
        this.speciesRepository.save(new Species(name));
        return true;
    }

    @Override
    public Species getSpecies(String name) {
        return this.speciesRepository.findSpeciesByName(name);
    }
}
