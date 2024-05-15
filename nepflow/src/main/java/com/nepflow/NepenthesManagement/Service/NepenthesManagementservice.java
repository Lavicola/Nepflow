package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.Producer;
import com.nepflow.NepenthesManagement.Model.SpeciesClone;

public interface NepenthesManagementservice {

    public boolean createNewNepenthes(String name);

    public boolean createNewClone(Clone clone);


    public SpeciesClone createNewSpeciesClone(SpeciesClone speciesClone,
                                                String nepenthesName,
                                                String cloneId,
                                                String location,
                                                String sex,
                                                String producer);



}
