package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NepenthesRetrivalServiceImpl implements NepenthesRetrivalService {



    @Override
    public List<ICClone> getSpeciesICClones() {
        return null;
    }

    @Override
    public List<IVClone> getSpeciesIVlones() {
        return null;
    }

    @Override
    public List<ICClone> getAllSpeciesClones() {
        return null;
    }
}
