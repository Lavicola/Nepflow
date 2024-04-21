package com.nepflow.Service;

import com.nepflow.Models.Species;

public interface SpeciesService {

    public boolean createNewSpecies(String name);
    public Species getSpecies(String name);
}
