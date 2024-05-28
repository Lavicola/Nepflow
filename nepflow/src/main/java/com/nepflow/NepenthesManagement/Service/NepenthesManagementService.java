package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.HybridLabel;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;

public interface NepenthesManagementService {
    // Species, since seeds are taken from the wild, can have a location
    IVClone saveIVNepenthesClone(Nepenthes label, String cloneId,
                                 String sexAsString, Grex grex,
                                 String locationAsString, String producerAsString);
    ICClone saveICNepenthesClone(Nepenthes label, String sexAsString,
                                 Grex grex, String locationAsString);

    IVClone saveIVHybridLabelClone(Label label, String cloneId,
                                   String sexAsString, Grex grex, String producerAsString);
    ICClone saveICHybridLabelClone(Label label, String sexAsString,
                                 Grex grex);


    Label createLabel(Label label);
    int getLabelCount(String className);



}
