package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

import java.util.List;

public interface NepenthesRetrivalService {


    Clone getCloneByInternalId(String internalCloneId);

    List<Clone> getClonesByLabelAndCloneTypeAndStartsWith(String labelName,String cloneTypeClass,String startsWith);


    Label getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(String labelClass,String nepenthesName,String cloneType);
    List<Label> getNepenthesByNepenthesType(String labelClass);

}
