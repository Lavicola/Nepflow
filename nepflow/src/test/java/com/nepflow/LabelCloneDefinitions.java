package com.nepflow;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LabelCloneDefinitions {

    public static Producer producer = new Producer("Andreas Wistuba","google");

    public static Sex male = new Sex("Male");
    public static Sex female = new Sex("Female");
    public static Location location  = new Location("MT Murud");

    public static Species species = new Species("aaa",0);
    public static Clone icSpeciesClone = new ICSpeciesClone(species,null,"IC-5555",location,producer);


}
