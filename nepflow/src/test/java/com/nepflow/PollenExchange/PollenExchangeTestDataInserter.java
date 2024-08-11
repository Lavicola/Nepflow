package com.nepflow.PollenExchange;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.Growlistmanagement.Service.GrowlistTestDataInserter;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Since for the PollenExchange a Growlist must exist  and Specimens, this Class extends GrowlistTestDataInserter and saves the Growlists and Specimens which are necessary
 * in order to be able to create the various models
 */

@Component
public class PollenExchangeTestDataInserter extends GrowlistTestDataInserter {


    public User user3 = new User("user3", "user3");


    Growlist growlistUser1;
    Growlist growlistUser2;

    Growlist growlistUser3;

    @Autowired
    GrowlistRepository growlistRepository;

    @Autowired
    SpecimenRepository specimenRepository;



    public Specimen user1Specimen1NoSex;
    public Specimen user1Specimen2Male;
    public Specimen user1Specimen3Female;

    public Specimen user2Specimen1NoSex;
    public Specimen user2Specimen2Male;
    public Specimen user2Specimen3Female;

    public Specimen user3Specimen1NoSex;
    public Specimen user3Specimen2Male;
    public Specimen user3Specimen3Female;


    public void insertData() {
        super.insertData();
        this.createSpecimensAndGrowlist();

    }

    public void deleteData() {
        super.deleteData();
        this.growlistRepository.deleteAll();
        this.specimenRepository.deleteAll();
    }


    public void createUsers() {
        super.createUsers();
        user3.setContactInformation("aaa");
        user3.setCountry(country);
        user3 = this.userRepository.save(user3);
    }

    private void createGrowlists() {
        growlistUser1 = this.growlistRepository.save(new Growlist(this.updateUserVersion(this.user1)));
        growlistUser2 = this.growlistRepository.save(new Growlist(this.updateUserVersion(this.user2)));
        growlistUser3 = this.growlistRepository.save(new Growlist(this.updateUserVersion(this.user3)));
    }

    private void createSpecimensAndGrowlist() {
        user1Specimen1NoSex = new Specimen(icSpeciesClone, this.user1);
        user1Specimen2Male = new Specimen(ivSpeciesCloneMale, this.user1);
        user1Specimen3Female = new Specimen(ivSpeciesCloneFemale, this.user1);
        this.growlistUser1 = new Growlist(user1);
        this.growlistUser1.addSpecimen(user1Specimen1NoSex);
        this.growlistUser1.addSpecimen(user1Specimen2Male);
        this.growlistUser1.addSpecimen(user1Specimen3Female);
        this.growlistRepository.save(growlistUser1);

        user2Specimen1NoSex = new Specimen(icSpeciesClone, this.user2);
        user2Specimen2Male  = new Specimen(ivSpeciesCloneMale, this.user2);
        user2Specimen3Female = new Specimen(ivSpeciesCloneFemale, this.user2);
        this.growlistUser2 = new Growlist(user2);

        this.growlistUser2.addSpecimen(user2Specimen1NoSex);
        this.growlistUser2.addSpecimen(user2Specimen2Male);
        this.growlistUser2.addSpecimen(user2Specimen3Female);
        this.growlistRepository.save(growlistUser2);

        user3Specimen1NoSex = new Specimen(icSpeciesClone, this.user3);
        user3Specimen2Male  = new Specimen(ivSpeciesCloneMale, this.user3);
        user3Specimen3Female=  new Specimen(ivSpeciesCloneFemale, this.user3);
        this.growlistUser3 = new Growlist(user3);

        this.growlistUser3.addSpecimen(user3Specimen1NoSex);
        this.growlistUser3.addSpecimen(user3Specimen2Male);
        this.growlistUser3.addSpecimen(user3Specimen3Female);
        this.growlistRepository.save(growlistUser3);

    }



    /**
     * These getters are necessary due to optimistic lock, because the Version is not valid if you perform
     * two times on the same specimen without changing the version  (thus loading it from the  repository again)
     */

    public Specimen getUpdatedSpecimenVersion(Specimen specimen) {
        return this.specimenRepository.findSpecimenByUuid(specimen.getUuid());

    }

}