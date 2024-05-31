package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
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
    public List<Label> getClonesByLabelClass(String labelClass) {
        return this.labelRepository.getClonesByLabelClass(labelClass);
    }

    @Override
    public List<Label> getClonesByLabelClassAndCloneClass(String labelClass, String cloneClass) {
        return this.labelRepository.getClonesByLabelClassAndCloneClass(labelClass,cloneClass);
    }

    @Override
    public List<Clone> getClonesByLabelAndCloneTypeAndStartsWith(String labelName, String cloneTypeClass, String startsWith) {
        return this.cloneRepository.findClonesByLabelAndCloneTypeAndStartsWith(labelName,cloneTypeClass,startsWith);
    }

    @Override
    public List<Label> getLabelsByLabelname(String labelName) {
        return this.labelRepository.getLabelsByLabelName(labelName);
    }


}
