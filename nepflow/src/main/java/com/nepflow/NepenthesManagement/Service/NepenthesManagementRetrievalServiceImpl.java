package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.*;
import com.nepflow.NepenthesManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NepenthesManagementRetrievalServiceImpl implements NepenthesManagementRetrievalService {

    @Autowired
    NepenthesRepository nepenthesRepository;

    @Autowired
    CloneRepository cloneRepository;

    @Override
    public List<Nepenthes> getNepenthesList(){
        return this.nepenthesRepository.findAll();
    }

    @Override
    public Nepenthes getNepenthes(String name) {
        return this.nepenthesRepository.findNepenthesByName(name);
    }

    @Override
    public Clone getCloneByID(String cloneId) {
        return this.cloneRepository.findCloneByCloneId(cloneId);
    }


    public List<Clone> getClonesByNepenthesName(String name){
        return this.cloneRepository.findClonesByName(name);
    }


    public List<SpeciesClone> getSpeciesClones(){
        return this.cloneRepository.getAllSpeciesClones();
    }


}
