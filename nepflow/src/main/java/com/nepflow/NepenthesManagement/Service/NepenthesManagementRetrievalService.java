package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.*;

import java.util.List;

public interface NepenthesManagementRetrievalService {

    List<Nepenthes> getNepenthesList();
    Clone getCloneByID(String cloneId);
    public List<Clone> getClonesByNepenthesName(String name);
    public List<SpeciesClone> getSpeciesClones();



}
