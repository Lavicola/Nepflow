package com.nepflow.Service;

import com.nepflow.Models.Clone;
import com.nepflow.Models.Species;
import org.springframework.stereotype.Service;

@Service
public interface CloneService {

    public boolean createNewSpeciesClone(Species species, String cloneId);
    public Clone getSpeciesClone(Species species, String cloneId);


}
