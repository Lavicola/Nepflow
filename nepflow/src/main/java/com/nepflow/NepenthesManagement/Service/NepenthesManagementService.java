package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Exception.CloneAlreadyHasASex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

public interface NepenthesManagementService {
    IVClone saveIVClone(Label label, String cloneId,
                                 String sexAsString,
                                 String locationAsString, String producerAsString);

    ICClone saveICClone(Label label, String sexAsString, String locationAsString, String sellerAsString);

    ICClone saveICCloneWithCloneId(Label label,String cloneId, String sexAsString, String locationAsString, String sellerAsString);

    IVClone saveIVClone(String labelName, String cloneId,
                        String sexAsString,
                        String locationAsString, String producerAsString);

    ICClone saveICClone(String labelName, String sexAsString, String locationAsString, String sellerAsString
    );


    Label createLabel(Label label);
    int getLabelCount(String className);

    // This Method is necessary for Growlist in order to create for a clone with an unkown sex an identical one with sex
    Clone getOrCreateSexedClone(Clone clone,String sexAsString) throws CloneAlreadyHasASex;




}
