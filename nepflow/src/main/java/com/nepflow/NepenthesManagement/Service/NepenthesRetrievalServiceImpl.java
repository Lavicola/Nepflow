package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.PrivateSeller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of NepenthesRetrievalService.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Service
public class NepenthesRetrievalServiceImpl implements NepenthesRetrievalService {

    /**
     * CloneRepository used to retrieve and store Clones into the Database.
     */
    @Autowired
    private CloneRepository cloneRepository;
    /**
     * LabelRepository used to retrieve and store Labels into the Database.
     */
    @Autowired
    private LabelRepository labelRepository;

    /**
     * Method Implementation to retrieve a Clone using it´s internal Clone Id.
     *
     * @param internalCloneId internale Id of a Clone
     * @return Clone object
     */
    @Override
    public Clone getCloneByInternalId(final String internalCloneId) {
        return this.cloneRepository.findCloneByInternalCloneId(internalCloneId);
    }


    /**
     * Method Implementation to retrieve a Label and all it´s Clones of a
     * specific Label class, a specific Nepenthes Name and Clone Type.
     * LabelClass could be determined at runtime, but this would cost more.
     *
     * @param labelClass    the name of a subclass of Label
     * @param nepenthesName Name of a Nepenthes to search for
     * @param cloneType     Clone Type to reduce the search space/amount of data to retrieve
     * @return Label object with only reference to a specific cloneType
     */
    @Override
    public Label getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(final String labelClass,
                                                                            final String nepenthesName,
                                                                            final String cloneType) {
        if (cloneType.contains("IV")) {
            return this.labelRepository.findLabelClonesByLabelAndNepenthesNameAndCloneType(labelClass, nepenthesName, cloneType, Producer.class.getSimpleName());
        } else {
            return this.labelRepository.findLabelClonesByLabelAndNepenthesNameAndCloneType(labelClass, nepenthesName, cloneType, PrivateSeller.class.getSimpleName());
        }
    }

    /**
     * Implementation to retrieve all Labels of a specific subclass Label.
     * @param labelClass the name of a subclass of Label
     * @return Label object without references
     */
    @Override
    public List<Label> getLabelsByNepenthesType(final String labelClass) {
        return this.labelRepository.getNepenthesByNepenthesType(labelClass);
    }


}
