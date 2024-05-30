package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;

import java.util.List;

public interface NepenthesRetrivalService {


    List<ICClone> getSpeciesICClones();
    List<IVClone> getSpeciesIVlones();

    List<ICClone> getAllSpeciesClones();


}
