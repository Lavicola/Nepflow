package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.SpeciesCloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneNepenthesServiceImpl implements CloneNepenthesService {


    @Autowired
    NepenthesManagementRetrievalService nepenthesManagementRetrievalService;

    @Autowired
    SpeciesCloneRepository speciesCloneRepository;

    @Autowired
    NepenthesRepository nepenthesRepository;



    @Override
    public boolean preconditionFulfilledClone(String cloneId, String nepenthesName) {
        return !this.speciesCloneRepository.existsSpeciesCloneByCloneIdAndNepenthesName(cloneId,nepenthesName);
    }


    @Override
    public boolean createNewNepenthesIndividualClone(String cloneId, String nepenthesName) {
        if(!this.preconditionFulfilledClone(cloneId,nepenthesName)){
            return false;
        }
        Nepenthes nepenthes = this.nepenthesManagementRetrievalService.getNepenthes(nepenthesName);
        ICClone ICClone = new ICClone(nepenthesName,cloneId,nepenthes);
        this.speciesCloneRepository.save(ICClone);
        return true;
    }

    @Override
    public boolean createNewNepenthesIVClone(String cloneId, String nepenthesName) {
        if(!this.preconditionFulfilledClone(cloneId,nepenthesName)){
            return false;
        }
        Nepenthes nepenthes = this.nepenthesManagementRetrievalService.getNepenthes(nepenthesName);
        IVClone ivClone = new IVClone(nepenthesName,cloneId,nepenthes);
        this.speciesCloneRepository.save(ivClone);

        return true;
    }

    @Override
    public boolean createNewNepenthes(String name) {
        if (this.nepenthesManagementRetrievalService.nepenthesExists(name)) {
            return false;
        }

        this.nepenthesRepository.save(new Nepenthes(name));
        Clone.validPlants.add(name);
        return true;
    }




}
