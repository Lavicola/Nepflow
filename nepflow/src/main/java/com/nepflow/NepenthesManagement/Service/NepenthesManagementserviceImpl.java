package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.Model.*;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NepenthesManagementserviceImpl implements NepenthesManagementservice {

    @Autowired
    NepenthesManagementMetaDataService nepenthesManagementMetaDataService;

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


    public SpeciesClone createNewSpeciesClone(SpeciesClone speciesClone,
                                              String nepenthesName,
                                              String cloneId,
                                              String location,
                                              String sex,
                                              String producer) {
        Nepenthes nepenthes = this.nepenthesManagementRetrievalService.getNepenthes(nepenthesName);
        Producer pro = this.nepenthesManagementMetaDataService.getProducer(producer);
        Location loc = this.nepenthesManagementMetaDataService.getLocation(location);
        Sex gender = this.nepenthesManagementMetaDataService.getSex(sex);
        // for now allow users to add a custom location
        if (loc == null) {
            loc = new Location(location);
        }

        speciesClone = speciesClone.createNewClones(nepenthesName, cloneId,
                nepenthes, loc, gender, pro);


        return this.cloneRepository.save(speciesClone);
    }


}
