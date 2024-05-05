package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;

import java.util.List;

public interface CloneNepenthesService {


    public boolean createNewNepenthesIndividualClone(String cloneId, String nepenthesName);
    public boolean createNewNepenthesIVClone(String cloneId, String nepenthesName); //TODO needs Producer
    public boolean createNewNepenthes(String name);
    // in order to create a new Clone certain conditions must be met
    public boolean preconditionFulfilledClone(String cloneId, String nepenthesName);


    public Clone getNepenthesClone(String cloneId, String nepenthesName);

    public boolean cloneExists(String cloneId, String nepenthesName);
    public boolean nepenthesExists(String nepenthesName);

    public Nepenthes getNepenthes(String name);
    public List<Nepenthes> getNepenthes();
    public List<Clone> getClonesOfNepenthes(String name);


}
