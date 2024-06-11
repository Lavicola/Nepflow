package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

public interface NepenthesManagementService {
    // Species, since seeds are taken from the wild, can have a location
    IVClone saveIVClone(Label label, String cloneId,
                                 String sexAsString, Grex grex,
                                 String locationAsString, String producerAsString);
    ICClone saveICClone(Label label, String sexAsString,
                                 Grex grex, String locationAsString,
                        String sellerAsString
                        );

    ICClone saveICCloneCultivar(Label label,String cloneId, String sexAsString,
                        Grex grex, String locationAsString,
                        String sellerAsString
    );


    Label createLabel(Label label);
    int getLabelCount(String className);

    ICClone saveICCloneInternalLabel (Label label,String cloneId, String sexAsString,
    Grex grex, String locationAsString,
    String sellerAsString
    );


}
