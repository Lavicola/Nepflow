package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.Model.Clone;

import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloneNepenthesServiceImpl implements CloneNepenthesService {


    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    NepenthesRepository nepenthesRepository;





    @Override
    public boolean preconditionFulfilledClone(String cloneId, String nepenthesName) {
        return !this.cloneRepository.existsByCloneIdAndNepenthesName(cloneId,nepenthesName);
    }


    @Override
    public boolean createNewNepenthesIndividualClone(String cloneId, String nepenthesName) {
        if(!this.preconditionFulfilledClone(cloneId,nepenthesName)){
            return false;
        }
        Nepenthes nepenthes = this.getNepenthes(nepenthesName);
        ICClone ICClone = new ICClone(cloneId,nepenthes);
        this.cloneRepository.save(ICClone);
        return true;
    }

    @Override
    public boolean createNewNepenthesIVClone(String cloneId, String nepenthesName) {
        Nepenthes nepenthes = this.getNepenthes(nepenthesName);
        IVClone ivClone = new IVClone(cloneId,nepenthes);
        this.cloneRepository.save(ivClone);


        return false;
    }

    @Override
    public boolean createNewNepenthes(String name) {
        if (this.nepenthesExists(name)) {
            return false;
        }

        this.nepenthesRepository.save(new Nepenthes(name));
        return true;
    }



    @Override
    public Nepenthes getNepenthes(String name) {
        return this.nepenthesRepository.findNepenthesByName(name);
    }

    @Override
    public Clone getNepenthesClone(String cloneId, String nepenthesName) {
        return this.cloneRepository.findClonesByCloneIdAndNepenthesName(cloneId, nepenthesName);
    }

    @Override
    public List<Nepenthes> getNepenthes() {
        return this.nepenthesRepository.findAll();
    }

    @Override
    public List<Clone> getClonesOfNepenthes(String name) {
        return this.cloneRepository.findClonesByNepenthesName(name);
    }


    @Override
    public boolean cloneExists(String cloneId, String nepenthesName) {
        return this.cloneRepository.existsByCloneIdAndNepenthesName(cloneId, nepenthesName);

    }

    @Override
    public boolean nepenthesExists(String nepenthesName) {
        return this.nepenthesRepository.existsByName(nepenthesName);
    }
}
