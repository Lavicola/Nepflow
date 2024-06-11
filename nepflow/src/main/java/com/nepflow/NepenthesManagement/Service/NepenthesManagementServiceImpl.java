package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.LabelRepository;
import com.nepflow.NepenthesManagement.Repository.LocationRepository;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NepenthesManagementServiceImpl implements NepenthesManagementService {

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ProducerRepository producerRepository;


    @Autowired
    NepenthesManagementMetaDataService managementMetaDataService;


    @Override
    public IVClone saveIVClone(Label label, String cloneId,
                               String sexAsString, Grex grex,
                               String locationAsString, String producerAsString) {
        IVClone newIvClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Producer producer = this.managementMetaDataService.getProducer(producerAsString);
        // only Location is allowed to be freely inserted
        Location location = this.managementMetaDataService.saveLocation(locationAsString);
        if (this.cloneRepository.existsByInternalCloneId(IVClone.generateInternalCloneId(cloneId, sex))) {
            // clone already exists
            return null;
        }
        newIvClone = label.addIVClone(cloneId, sex, grex, location, producer);
        this.labelRepository.save(label);
        return newIvClone;
    }

    @Override
    public ICClone saveICClone(Label label, String sexAsString, Grex grex,
                               String locationAsString, String sellerAsString) {
        Location location;
        ICClone newIcClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Seller seller = this.managementMetaDataService.getSeller(sellerAsString);
        // only Location is allowed to be freely inserted, but for now we dont allow Location for Multihybrids
        if (label instanceof MultiHybrid) {
            location = null;
        } else {
            location = this.managementMetaDataService.saveLocation(locationAsString);

        }
        newIcClone = label.addICClone(sex, location, grex,seller);
        this.labelRepository.save(label);
        return newIcClone;
    }

    @Override
    //TODO at some point remove Code duplication --> helper method for common logic
    public ICClone saveICCloneCultivar(Label label, String cloneId, String sexAsString, Grex grex, String locationAsString, String sellerAsString) {
        Location location;
        ICClone newIcClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Seller seller = this.managementMetaDataService.getSeller(sellerAsString);
        // only Location is allowed to be freely inserted, but for now we dont allow Location for Multihybrids
        if (label instanceof MultiHybrid) {
            location = null;
        } else {
            location = this.managementMetaDataService.saveLocation(locationAsString);

        }
        newIcClone = label.addICCloneCultivar(sex,cloneId, location, grex,seller);
        this.labelRepository.save(label);
        return newIcClone;
    }

    @Override
    public Label createLabel(Label label) {
        Label rLabel = this.labelRepository.findLabelByName(label.getName());
        if (rLabel != null) {
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

    @Override
    public ICClone saveICCloneInternalLabel(Label label, String cloneId, String sexAsString, Grex grex, String locationAsString, String sellerAsString) {
        return null;
    }


}
