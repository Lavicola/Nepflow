package com.nepflow;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;

public class LabelCloneDefinitions {


    public static Producer producer = new Producer("Andreas Wistuba","google");
    public static Species species = new Species("aaa",0);
    public  static PrimaryHybrid hybrid = new PrimaryHybrid("(hamata x villosa)",0);
    public  static MultiHybrid multiHybrid = new MultiHybrid("(hamata x villosa) x lowii",0);

    public static Clone ivSpeciesClone = new IVSpeciesClone(species,"IV-55",null,null,producer);
    public static Clone icSpeciesClone = new ICSpeciesClone(species,null,"IC-5555",null,producer);

    public static Sex male = new Sex("Male");
    public static Sex female = new Sex("female");
}
