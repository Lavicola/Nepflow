package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.NepenthesClone;
import com.nepflow.GrowlistManagement.Repository.NepenthesCloneRepository;
import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.IVCloneRepository;
import com.nepflow.NepenthesManagement.Repository.IndividualCloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import com.nepflow.NepenthesManagement.Service.NepenthesAndCloneRetrivalService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GrowListserviceImpl implements GrowListService{

    @Autowired
    NepenthesAndCloneRetrivalService nepenthesAndCloneRetrivalService;

    @Autowired
    NepenthesCloneRepository nepenthesCloneRepository;

    @Autowired
    IVCloneRepository ivCloneRepository;

    @Transactional("transactionManager")
    public NepenthesClone addNepenthesCloneToUser(String cloneId,String nepenthesName, User user) {
        if(!this.verifyCloneAndNepenthesCombination(cloneId,nepenthesName)){
            return null;
        }
        IVClone clone =  this.ivCloneRepository.findIVCloneByCloneIdAndNepenthesName(cloneId,nepenthesName);
        NepenthesClone nepenthesClone = new NepenthesClone(user,clone);
        this.nepenthesCloneRepository.save(nepenthesClone);
        return nepenthesClone;
    }

    @Override
    public boolean verifyCloneAndNepenthesCombination(String cloneId,String nepenthesName) {

        return this.nepenthesAndCloneRetrivalService.cloneExists(cloneId,nepenthesName);
    }

    @Override
    public List<NepenthesClone> getNepenthesOfUser(User user) {
        return this.nepenthesCloneRepository.findAll();
    }
}
