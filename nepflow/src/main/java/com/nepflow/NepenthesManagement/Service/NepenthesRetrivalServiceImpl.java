package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NepenthesRetrivalServiceImpl implements NepenthesRetrivalService {

    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    LabelRepository labelRepository;

    @Override
    public Clone getCloneByInternalId(String internalCloneId) {
        return this.cloneRepository.findICCloneByInternalCloneId(internalCloneId);
    }



    @Override
    public List<Clone> getClonesByLabelAndCloneTypeAndStartsWith(String labelName, String cloneTypeClass, String startsWith) {
        return this.cloneRepository.findClonesByLabelAndCloneTypeAndStartsWith(labelName,cloneTypeClass,startsWith);
    }



    @Override
    public Label getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(String labelClass, String nepenthesName, String cloneType) {
        return this.labelRepository.findLabelClonesByLabelAndNepenthesNameAndCloneType(labelClass,nepenthesName,cloneType);
    }

    @Override
    public List<Label> getNepenthesByNepenthesType(String labelClass) {
        return this.labelRepository.getNepenthesByNepenthesType(labelClass);
    }


}
