package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;

import java.util.List;

public interface NepenthesAndCloneRetrivalService {

    public boolean cloneExists(String cloneId, String nepenthesName);
    public boolean nepenthesExists(String nepenthesName);

    Nepenthes getNepenthes(String name);
    List<Nepenthes> getNepenthes();
    List<Clone> getClonesOfNepenthes(String name);
    Clone getNepenthesClone(String cloneId, String nepenthesName);


}
