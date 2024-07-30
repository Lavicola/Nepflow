package com.nepflow.Growlistmanagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Repository.*;
import com.nepflow.UserManagement.Model.Country;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.CountryRepository;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrowlistTestDataInserter {

    public Producer producer = new Producer("Andreas Wistuba","google");

    public Sex male = new Sex("Male");
    public Sex female = new Sex("Female");
    public User user1 = new User("user1","user1");
    public User user2 = new User("user2","user2");
    public Country country = new Country("USA");
    public Location location  = new Location("MT Murud");

    public Species species = new Species("aaa",0);
    public Clone ivSpeciesCloneMale = new IVSpeciesClone(species,"IV-55",male,location,producer);
    public Clone ivSpeciesCloneFemale = new IVSpeciesClone(species,"IV-55",female,location,producer);

    public Clone icSpeciesClone = new ICSpeciesClone(species,null,"IC-5555",location,producer);

    public Clone cloneNotInDBIV = new IVSpeciesClone(species,"IV-551",male,location,producer);
    public Clone cloneNotInDBIC = new ICSpeciesClone(species,null,"NO-5555",location,producer);


    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
   protected UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    SexRepository sexRepository;

    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    LabelRepository labelRepository;


    public void insertData() {
        this.createCountries();
        this.createProducer();
        this.createSexes();
        this.createUsers();
        this.createLocations();
        this.createLabelsAndClones();
        updateClones();

    }

    public void deleteData(){
        this.countryRepository.deleteAll();
        this.locationRepository.deleteAll();
        this.producerRepository.deleteAll();
        this.sexRepository.deleteAll();
        this.userRepository.deleteAll();
        this.labelRepository.deleteAll();
        this.cloneRepository.deleteAll();
    }

    public void createCountries() {
        this.countryRepository.save(country);
    }

    public void createLocations() {
       location = this.locationRepository.save(location);
    }


    public void createSexes() {
      male=  this.sexRepository.save(male);
       female = this.sexRepository.save(female);
    }

    public void createProducer() {
       producer = this.producerRepository.save(producer);
    }

    public void createUsers() {
        user1.setContactInformation("aaa");
        user1.setCountry(country);
        user2.setContactInformation("aaa");
        user2.setCountry(country);
        user1 = this.userRepository.save(user1);
        user2 = this.userRepository.save(user2);
    }

    public void createLabelsAndClones() {
        icSpeciesClone = species.createICClone(icSpeciesClone.getCloneId(),icSpeciesClone.getSex(),
                icSpeciesClone.getLocation(), producer);
        ivSpeciesCloneMale = species.createIVClone(ivSpeciesCloneMale.getCloneId(), ivSpeciesCloneMale.getSex(),
                ivSpeciesCloneMale.getLocation(), producer);
        ivSpeciesCloneFemale = species.createIVClone(ivSpeciesCloneFemale.getCloneId(), ivSpeciesCloneFemale.getSex(),
                ivSpeciesCloneFemale.getLocation(), producer);

        species.addICClone(icSpeciesClone.getSex(),icSpeciesClone.getCloneId(),
                icSpeciesClone.getLocation(), producer);

        species.addIVClone(ivSpeciesCloneMale.getCloneId(), ivSpeciesCloneMale.getSex(),
               ivSpeciesCloneMale.getLocation(), producer);

        species.addIVClone(ivSpeciesCloneFemale.getCloneId(), ivSpeciesCloneFemale.getSex(),
                ivSpeciesCloneFemale.getLocation(), producer);
        this.species = this.labelRepository.save(species);

    }

    public void updateClones(){
        icSpeciesClone = this.cloneRepository.findCloneByInternalCloneId(Clone.generateInternalCloneId(icSpeciesClone.getCloneId(),icSpeciesClone.getSex()));
        ivSpeciesCloneMale = this.cloneRepository.findCloneByInternalCloneId(Clone.generateInternalCloneId(ivSpeciesCloneMale.getCloneId(), ivSpeciesCloneMale.getSex()));
        ivSpeciesCloneFemale = this.cloneRepository.findCloneByInternalCloneId(Clone.generateInternalCloneId(ivSpeciesCloneFemale.getCloneId(), ivSpeciesCloneFemale.getSex()));
    }


    public User updateUserVersion(User user){
        return this.userRepository.findUserByOAuthId(user.getOAuthId());
    }

}
