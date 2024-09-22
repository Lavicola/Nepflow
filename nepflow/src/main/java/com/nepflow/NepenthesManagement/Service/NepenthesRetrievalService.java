package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

import java.util.List;
import java.util.Set;

/**
 * Interface which defines Methods to retrieve Nepenthes and Labels.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
public interface NepenthesRetrievalService {


    /**
     * Method definition to retrieve a Clone using it´s internal Clone Id.
     * @param internalCloneId internale Id of a Clone
     * @return Clone object
     */
    Clone getCloneByInternalCloneId(String internalCloneId);

    /**
     * Method definition to retrieve a List of Clones using internal Clone Ids.
     * @param internalCloneIds internal Ids of the clones
     * @return List of Clone object
     */
    List<Clone> getClonesByInternalCloneId(Set<String> internalCloneIds);


    /**
     * Method definition to retrieve Clones using their cloneIds.
     * @param cloneIds ids  of the clones to retrieve
     * @return Clone object
     */
    List<Clone> getClonesByCloneId(List<String> cloneIds);


    /**
     * Method definition to retrieve a Label and all it´s Clones of a specific Label class,
     * a specific Nepenthes Name and Clone Type.
     * LabelClass could be determined at runtime, but this would cost more.
     * @param labelClass the name of a subclass of Label
     * @param nepenthesName Name of a Nepenthes to search for
     * @param cloneType Clone Type to reduce the search space/amount of data to retrieve
     * @return Label object with only reference to a specific cloneType
     */
    Label getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(String labelClass,
                                                                     String nepenthesName,
                                                                     String cloneType);

    /**
     * Method definition to retrieve all Labels of a specific subclass Label.
     * @param labelClass the name of a subclass of Label
     * @return Label object
     */
    List<Label> getLabelsByNepenthesType(String labelClass);

}
