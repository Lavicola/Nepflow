package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

public interface NepenthesManagementService {
    IVClone saveIVClone(Label label, String cloneId,
                                 String sexAsString,
                                 String locationAsString, String producerAsString);

    ICClone saveICClone(Label label, String sexAsString, String locationAsString, String sellerAsString);

    IVClone saveIVClone(String labelName, String cloneId,
                        String sexAsString,
                        String locationAsString, String producerAsString);

    ICClone saveICClone(String labelName, String sexAsString, String locationAsString, String sellerAsString
    );


    Label createLabel(Label label);
    int getLabelCount(String className);




}
