package com.nepflow;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.UserManagement.Model.Country;
import com.nepflow.UserManagement.Model.User;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LabelCloneDefinitions {

    public static Producer producer = new Producer("Andreas Wistuba","google");
    public static Country country = new Country("USA");

    public static User user1 = new User("user1","user1",country);
    public static User user2 = new User("user2","user2",country);
    public static User user3 = new User("user3","user3",country);

    public static Sex male = new Sex("Male");
    public static Sex female = new Sex("Female");
    public static Location location  = new Location("MT Murud");

    public static Species species = new Species("aaa",0);

    public static Clone icSpeciesCloneNoSex = new ICSpeciesClone(species,null,"IC-5555",location,producer);

    public static Clone icSpeciesClone = new ICSpeciesClone(species,male,"IC-5555",location,producer);
    public static Clone icSpeciesClone2 = new ICSpeciesClone(species,female,"IC-5555",location,producer);

    public static Specimen specimenUser1Male = new Specimen(icSpeciesClone,user1);
    public static Specimen specimenUser2Female = new Specimen(icSpeciesClone2,user2);
    public static Specimen specimenUser3NoSex = new Specimen(icSpeciesCloneNoSex,user3);


}
