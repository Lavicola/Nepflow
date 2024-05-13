package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.*;

import java.util.List;

public interface NepenthesManagementRetrievalService {

    public boolean cloneExists(String cloneId, String nepenthesName);
    public boolean nepenthesExists(String nepenthesName);

    Nepenthes getNepenthes(String name);

    List<Nepenthes> getNepenthes();
    List<SpeciesClone> getClonesOfNepenthes(String name);

    List<Hybrid> getAllHybrids();
    List<Hybrid> getHybridsByName(String name);
    Hybrid getHybridsByCloneId(String cloneId);

    List<MultiHybrid> getAllMultiHybrids();
    List<MultiHybrid> getMultiHybridsByName(String name);
    MultiHybrid getMultiHybridsByCloneId(String cloneId);

    Clone getNepenthesClone(String cloneId, String nepenthesName);


}
