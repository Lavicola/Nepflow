package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementService;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GrowlistServiceImpl implements Growlistservice {

    @Autowired
    GrowlistRepository growListRepository;

    @Autowired
    SpecimenRepository specimenRepository;

    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    @Autowired
    NepenthesManagementService nepenthesManagementService;


    @Override
    public void createGrowlist(User user) {
        this.growListRepository.save(new Growlist(user));
    }

    @Override
    public Growlist getGrowlist(String username) {
        return this.growListRepository.findGrowlistByUsername(username);
    }

    @Override
    public Specimen addExistingCloneToGrowList(User user, String internalId) {
        Growlist growlist = this.growListRepository.findGrowlistById(user.getOAuthId());
        Clone clone = this.nepenthesRetrivalService.getCloneByInternalId(internalId);
        Specimen specimen = null;
        if (growlist != null && clone != null) {
            specimen = new Specimen(clone);
            growlist.addSpecimen(specimen);
            this.growListRepository.save(growlist);
        } else {
            //should not happen
        }

        return specimen;
    }

    @Override
    @Transactional("transactionManager")
    public Specimen addNewIVCloneToGrowList(User user, String labelName, String cloneId, String sexAsString, String locationAsString, String producerAsString) {
        Clone clone = this.nepenthesManagementService.saveIVClone(labelName, cloneId, sexAsString, locationAsString, producerAsString);

        // MUST be retrieved, otherwise optimistic locking
        clone = this.nepenthesRetrivalService.getCloneByInternalId(clone.getInternalCloneId());

        Growlist growlist = this.growListRepository.findGrowlistById(user.getOAuthId());


        Specimen specimen = new Specimen(clone);

        if (clone != null && growlist != null) {

            growlist.addSpecimen(specimen);

            this.growListRepository.save(growlist);
        }

        return specimen;
    }

    @Override
    @Transactional("transactionManager")
    public Specimen addNewICCloneToGrowList(User user, String labelName, String cloneId, String sexAsString, String locationAsString, String sellerAsString) {
        Clone clone = this.nepenthesManagementService.saveICClone(labelName, sexAsString, locationAsString, sellerAsString);
        Growlist growlist = this.growListRepository.findGrowlistByUser(user);
        Specimen specimen = null;
        specimen = new Specimen(clone);
        if (clone != null && growlist != null) {
            growlist.addSpecimen(specimen);
            this.growListRepository.save(growlist);
        }


        return specimen;
    }


}
