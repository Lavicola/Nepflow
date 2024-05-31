package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

import java.util.List;

public interface NepenthesRetrivalService {

    List<Label> getClonesByLabelClass(String labelClass);
    List<Label> getClonesByLabelClassAndCloneClass(String labelClass,String cloneClass);

    List<Clone> getClonesByLabelAndCloneTypeAndStartsWith(String labelName,String cloneTypeClass,String startsWith);


    List<Label> getLabelsByLabelname(String labelName);

}
