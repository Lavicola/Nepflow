package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.Model.*;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NepenthesManagementserviceImpl implements NepenthesManagementservice {


    @Autowired
    NepenthesManagementRetrievalService nepenthesManagementRetrievalService;

    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    NepenthesRepository nepenthesRepository;


    @Override
    public boolean createNewNepenthes(String name) {
        return false;
    }

    @Override
    public boolean createNewClone(Clone clone) {




        return false;
    }




}
