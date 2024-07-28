package com.nepflow.PollenExchange;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.Growlistmanagement.Service.GrowlistTestDataInserter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Since for the PollenExchange a Growlist must exist  and Specimens, this Class extends GrowlistTestDataInserter and saves the Growlists and Specimens which are necessary
 * in order to be able to create the various models
 */

@Component
public class PollenExchangeTestDataInserter extends GrowlistTestDataInserter {


    Growlist growlistUser1;
    Growlist growlistUser2;

    @Autowired
    GrowlistRepository growlistRepository;

    @Autowired
    SpecimenRepository specimenRepository;

    public Specimen user1Specimen;
    public Specimen user1Specimen2;
    public Specimen user1Specimen3;

    public Specimen user2Specimen;
    public Specimen user2Specimen2;
    public Specimen user2Specimen3;

    public void insertData() {
        super.insertData();
        this.createGrowlists();
        this.createSpecimens();
        this.updateSpecimens();

    }

    public void deleteData() {
        super.deleteData();
        this.growlistRepository.deleteAll();
        this.specimenRepository.deleteAll();
    }



    private void createGrowlists() {
        growlistUser1 = this.growlistRepository.save(new Growlist(this.user1));
        growlistUser2 = this.growlistRepository.save(new Growlist(this.user2));
    }

    private void createSpecimens() {
        this.growlistUser1.addSpecimen(new Specimen(icSpeciesClone));
        this.growlistUser1.addSpecimen(new Specimen(ivSpeciesClone));
        this.growlistUser1.addSpecimen(new Specimen(ivSpeciesClone2));
        growlistUser1 = this.growlistRepository.save(growlistUser1);
        this.growlistUser2.addSpecimen(new Specimen(icSpeciesClone));
        this.growlistUser2.addSpecimen(new Specimen(ivSpeciesClone));
        this.growlistUser2.addSpecimen(new Specimen(ivSpeciesClone2));
        growlistUser2 = this.growlistRepository.save(growlistUser2);
    }

    private void updateSpecimens() {
        this.user1Specimen = this.specimenRepository.findSpecimenByUuid(growlistUser1.getSpecimens().get(0).getUuid());
        this.user1Specimen2 = this.specimenRepository.findSpecimenByUuid(growlistUser1.getSpecimens().get(1).getUuid());
        this.user1Specimen3 = this.specimenRepository.findSpecimenByUuid(growlistUser1.getSpecimens().get(2).getUuid());

        this.user2Specimen = this.specimenRepository.findSpecimenByUuid(growlistUser2.getSpecimens().get(0).getUuid());
        this.user2Specimen2 = this.specimenRepository.findSpecimenByUuid(growlistUser2.getSpecimens().get(1).getUuid());
        this.user2Specimen3 = this.specimenRepository.findSpecimenByUuid(growlistUser2.getSpecimens().get(2).getUuid());
    }

    /**
     * These getters are necessary due to optimistic lock, because the Version is not valid if you perform
     * two times on the same specimen without changing the version  (thus loading it from the  repository again)
     */
    public Specimen getUser1Specimen() {
        return this.specimenRepository.findSpecimenByUuid(user1Specimen.getUuid());
    }

    public Specimen getUser1Specimen2() {
        return this.specimenRepository.findSpecimenByUuid(user1Specimen2.getUuid());
    }

    public Specimen getUser1Specimen3() {
        return this.specimenRepository.findSpecimenByUuid(user1Specimen3.getUuid());
    }


    public Specimen getUser2Specimen() {
        return this.specimenRepository.findSpecimenByUuid(user2Specimen.getUuid());
    }

    public Specimen getUser2Specimen2() {
        return this.specimenRepository.findSpecimenByUuid(user2Specimen2.getUuid());
    }

    public Specimen getUser2Specimen3() {
        return this.specimenRepository.findSpecimenByUuid(user2Specimen3.getUuid());
    }

}