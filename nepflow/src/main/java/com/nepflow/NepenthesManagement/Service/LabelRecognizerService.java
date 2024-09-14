package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Labels.Label;
/**
 * Interface which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @version 14. Nov 2024
 * @author David Schmidt
 */
public interface LabelRecognizerService  {

    /**
     * Returns the appropriate Label instance based on the provided name.
     * @param name the name used to determine the right Label class
     * @return the Label instance corresponding to the specified name
     */
    Label returnRightLabelClass(String name);

}
