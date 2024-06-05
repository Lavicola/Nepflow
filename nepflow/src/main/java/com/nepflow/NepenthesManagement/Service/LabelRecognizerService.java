package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Labels.Label;

/**
 * Since it is easy to recognize whether a Label is of Type Nepenthes/Hybrid/MultiHybrid this
 * class is used to return the select right Label Class.
 */
public interface LabelRecognizerService  {

    Label returnRightLabelClass(String name);


}
