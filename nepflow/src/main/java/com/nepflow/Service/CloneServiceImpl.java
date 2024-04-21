package com.nepflow.Service;

import com.nepflow.Models.Clone;
import com.nepflow.Models.Species;
import com.nepflow.Repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneServiceImpl implements CloneService {

    @Autowired
    CloneRepository cloneRepository;


    public CloneServiceImpl(){
        return;
    }


    @Override
    public boolean createNewSpeciesClone(Species species, String cloneId) {
        Clone clone = this.getSpeciesClone(species, cloneId);
        if (clone != null) {
            return false;
        }
        this.cloneRepository.save(new Clone(cloneId, species));
        return true;
    }

    @Override
    public Clone getSpeciesClone(Species species, String cloneId) {
        return this.cloneRepository.findCloneByCloneIdAndSpeciesName(species.getName(), cloneId);
    }
}
