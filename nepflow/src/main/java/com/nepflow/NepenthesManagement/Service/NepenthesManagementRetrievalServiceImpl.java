package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.*;
import com.nepflow.NepenthesManagement.Repository.HybridRepository;
import com.nepflow.NepenthesManagement.Repository.MultiHybridRepository;
import com.nepflow.NepenthesManagement.Repository.SpeciesCloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NepenthesManagementRetrievalServiceImpl implements NepenthesManagementRetrievalService {

    @Autowired
    NepenthesRepository nepenthesRepository;

    @Autowired
    SpeciesCloneRepository speciesCloneRepository;

    @Autowired
    MultiHybridRepository multiHybridRepository;

    @Autowired
    HybridRepository hybridRepository;


    @Override
    public Nepenthes getNepenthes(String name) {
        return this.nepenthesRepository.findNepenthesByName(name);
    }

    @Override
    public Clone getNepenthesClone(String cloneId, String nepenthesName) {
        return this.speciesCloneRepository.findSpeciesCloneByCloneIdAndNepenthesName(cloneId, nepenthesName);
    }

    @Override
    public List<Nepenthes> getNepenthes() {
        return this.nepenthesRepository.findAll();
    }

    @Override
    public List<SpeciesClone> getClonesOfNepenthes(String name) {
        return this.speciesCloneRepository.findAllByNepenthesName(name);
    }

    @Override
    public List<Hybrid> getAllHybrids() {
        return this.hybridRepository.findAll();
    }

    @Override
    public List<Hybrid> getHybridsByName(String name) {
        return this.hybridRepository.getHybridByName(name);
    }

    @Override
    public Hybrid getHybridsByCloneId(String cloneId) {
        return this.hybridRepository.getHybridByCloneId(cloneId);
    }

    @Override
    public List<MultiHybrid> getAllMultiHybrids() {
        return this.multiHybridRepository.findAll();
    }

    @Override
    public List<MultiHybrid> getMultiHybridsByName(String name) {
        return this.multiHybridRepository.getMultiHybridByName(name);
    }

    @Override
    public MultiHybrid getMultiHybridsByCloneId(String cloneId) {
        return this.multiHybridRepository.getMultiHybridByCloneId(cloneId);
    }


    @Override
    public boolean cloneExists(String cloneId, String nepenthesName) {
        return this.speciesCloneRepository.existsSpeciesCloneByCloneIdAndNepenthesName(cloneId, nepenthesName);

    }

    @Override
    public boolean nepenthesExists(String nepenthesName) {
        return this.nepenthesRepository.existsByName(nepenthesName);
    }

}
