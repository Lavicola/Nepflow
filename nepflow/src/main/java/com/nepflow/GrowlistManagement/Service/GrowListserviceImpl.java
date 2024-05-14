package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.NepenthesClone;
import com.nepflow.GrowlistManagement.Repository.NepenthesCloneRepository;
import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.SpeciesCloneRepository;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementRetrievalService;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GrowListserviceImpl implements GrowListService{

    @Autowired
    NepenthesManagementRetrievalService nepenthesManagementRetrievalService;

    @Autowired
    NepenthesCloneRepository nepenthesCloneRepository;

    @Autowired
    SpeciesCloneRepository speciesCloneRepository;

    @Autowired
    CloneRepository cloneRepository;

    @Transactional("transactionManager")
    public NepenthesClone addNepenthesCloneToUser(String cloneId,String nepenthesName, User user) {
        Clone clone = this.nepenthesManagementRetrievalService.getCloneByID(cloneId);
        if(clone == null){
            return null;
        }
        NepenthesClone nepenthesClone = new NepenthesClone(user,clone);
        this.nepenthesCloneRepository.save(nepenthesClone);
        return nepenthesClone;
    }



    @Override
    public List<NepenthesClone> getNepenthesOfUser(User user) {
        return this.nepenthesCloneRepository.findAll();
    }
}
