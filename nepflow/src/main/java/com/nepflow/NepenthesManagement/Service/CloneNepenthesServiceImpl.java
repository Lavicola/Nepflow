package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneNepenthesServiceImpl implements CloneNepenthesService {


    @Autowired
    NepenthesAndCloneRetrivalService nepenthesAndCloneRetrivalService;

    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    NepenthesRepository nepenthesRepository;


    @Override
    public boolean preconditionFulfilledClone(String cloneId, String nepenthesName) {
        return !this.cloneRepository.existsCloneByCloneIdAndNepenthesName(cloneId,nepenthesName);
    }


    @Override
    public boolean createNewNepenthesIndividualClone(String cloneId, String nepenthesName) {
        if(!this.preconditionFulfilledClone(cloneId,nepenthesName)){
            return false;
        }
        Nepenthes nepenthes = this.nepenthesAndCloneRetrivalService.getNepenthes(nepenthesName);
        ICClone ICClone = new ICClone(cloneId,nepenthes);
        this.cloneRepository.save(ICClone);
        return true;
    }

    @Override
    public boolean createNewNepenthesIVClone(String cloneId, String nepenthesName) {
        if(!this.preconditionFulfilledClone(cloneId,nepenthesName)){
            return false;
        }
        Nepenthes nepenthes = this.nepenthesAndCloneRetrivalService.getNepenthes(nepenthesName);
        IVClone ivClone = new IVClone(cloneId,nepenthes);
        this.cloneRepository.save(ivClone);

        return true;
    }

    @Override
    public boolean createNewNepenthes(String name) {
        if (this.nepenthesAndCloneRetrivalService.nepenthesExists(name)) {
            return false;
        }

        this.nepenthesRepository.save(new Nepenthes(name));
        return true;
    }




}
