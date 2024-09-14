package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Exception.CloneAlreadyHasASex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;

/**
 * Interface which defines Methods to store Nepenthes and Labels.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
public interface NepenthesManagementService {
    /**
     * Method definition to create a new IVClone using a subclass of Label.
     *
     * @param label            any Subclass of a Label
     * @param cloneId          the unique Id of a clone
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param producerAsString the IV Seller of the clone
     * @return IVClone object corresponding to the right Label
     */
    IVClone saveIVClone(Label label, String cloneId,
                        String sexAsString,
                        String locationAsString, String producerAsString);

    /**
     * Method definition to create a new ICClone using a subclass of Label.
     *
     * @param label            any Subclass of a Label
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param sellerAsString   the (private) seller of a IC clone
     * @return ICCLone object corresponding to the right Label
     */
    ICClone saveICClone(Label label, String sexAsString,
                        String locationAsString, String sellerAsString);

    /**
     * Method definition to create a new ICClone with a specific cloneId
     * using a subclass of Label.
     *
     * @param label            any Subclass of a Label
     * @param cloneId          the unique Id of a clone
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param sellerAsString   the IV Seller of the clone
     * @return ICCLone object corresponding to the right Label
     */
    ICClone saveICCloneWithCloneId(Label label, String cloneId,
                                   String sexAsString, String locationAsString,
                                   String sellerAsString);

    /**
     * Method definition to create a new IVClone
     * using a subclass of Label determined at runtime.
     * @param labelName name of the Label to determine the concrete Label class
     * @param cloneId the unique Id of a clone
     * @param sexAsString the sex of a clone
     * @param locationAsString the origin of the clone
     * @param producerAsString name of the producer
     * @return IVClone object corresponding to the right Label
     */
    IVClone saveIVClone(String labelName, String cloneId, String sexAsString,
                        String locationAsString, String producerAsString);

    /**
     * Method definition to create a new ICClone
     * using a subclass of Label determined at runtime.
     * @param labelName name of the Label to determine the concrete Label class
     * @param sexAsString the sex of a clone
     * @param locationAsString the origin of the clone
     * @param sellerAsString name of the seller
     * @return IVClone object corresponding to the right Label
     */
    ICClone saveICClone(String labelName, String sexAsString,
                        String locationAsString, String sellerAsString);


    /**
     * Method definition to store a Label into the Database.
     * @param label concrete Label to store into the Database
     * @return concrete Label object stored in the Database
     */
    Label createLabel(Label label);

    /**
     * Method definition to retrieve the Amount of different subclass Labels.
     * @param className Name of the (subclass) Label
     * @return amount of different (subclass) Label
     */
    int getLabelCount(String className);

    /**
     * Method definition to create for an existing unknown clone an identical sexed clone
     * This Method is used in the Frontend for Growlist in order be able to change
     * the Sex of at first unknown sexed clone.
     * @param clone clone to clone
     * @param sexAsString sex of the clone to clone
     * @return sexed clone
     * @throws CloneAlreadyHasASex if Clone with sex already exists
     */
    Clone getOrCreateSexedClone(Clone clone, String sexAsString) throws CloneAlreadyHasASex;


}
