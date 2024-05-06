package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NepenthesAndCloneRetrivalServiceImpl implements NepenthesAndCloneRetrivalService {

    @Autowired
    NepenthesRepository nepenthesRepository;

    @Autowired
    CloneRepository cloneRepository;


    @Override
    public Nepenthes getNepenthes(String name) {
        return this.nepenthesRepository.findNepenthesByName(name);
    }

    @Override
    public Clone getNepenthesClone(String cloneId, String nepenthesName) {
        return this.cloneRepository.findCloneByCloneIdAndNepenthesName(cloneId, nepenthesName);
    }

    @Override
    public List<Nepenthes> getNepenthes() {
        return this.nepenthesRepository.findAll();
    }

    @Override
    public List<Clone> getClonesOfNepenthes(String name) {
        return this.cloneRepository.findAllByNepenthesName(name);
    }


    @Override
    public boolean cloneExists(String cloneId, String nepenthesName) {
        return this.cloneRepository.existsCloneByCloneIdAndNepenthesName(cloneId, nepenthesName);

    }

    @Override
    public boolean nepenthesExists(String nepenthesName) {
        return this.nepenthesRepository.existsByName(nepenthesName);
    }

}
