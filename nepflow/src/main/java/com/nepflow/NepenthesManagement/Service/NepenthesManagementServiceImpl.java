package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NepenthesManagementServiceImpl implements NepenthesManagementService{

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    IVCloneRepository ivCloneRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ProducerRepository producerRepository;


    @Autowired
    NepenthesManagementMetaDataService managementMetaDataService;

    @Override
    public IVClone saveIVNepenthesClone(Nepenthes label, String cloneId,
                                        String sexAsString, Grex grex,
                                        String locationAsString, String producerAsString) {
        IVClone newIvClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Producer producer = this.managementMetaDataService.getProducer(producerAsString);
        // only Location is allowed to be freely inserted
        Location location = this.managementMetaDataService.saveLocation(locationAsString);
        if(this.cloneRepository.existsByInternalCloneId(IVClone.generateInternalCloneId(cloneId,sex))){
            // clone already exists
            return null;
        }
        newIvClone = label.addIVClone(cloneId,sex,grex,producer,location);
        this.labelRepository.save(label);
       return newIvClone;
    }

    @Override
    public ICClone saveICNepenthesClone(Nepenthes label, String sexAsString,
                                        Grex grex, String locationAsString) {
        ICClone newICClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Location location = this.managementMetaDataService.saveLocation(locationAsString);
        newICClone = label.addICClone(sex,grex,location);
        this.labelRepository.save(label);
        return newICClone;
    }

    @Override
    public Label createLabel(Label label) {
        Label rLabel = this.labelRepository.findLabelByName(label.getName());
        if(rLabel != null){
            return rLabel;
        }
        int labelCount = this.getLabelCount(label.getClass().getSimpleName());

        label.setPrefixIfEmpty(labelCount);
        return this.labelRepository.save(label);
    }

    @Override
    public int getLabelCount(String className) {
        return this.labelRepository.countLabelByLabelClass(className);
    }




}
