package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Exception.CloneAlreadyHasASex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of NepenthesManagementService.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Service
public class NepenthesManagementServiceImpl implements NepenthesManagementService {

    /**
     * LabelRepository used to retrieve and store Labels into the Database.
     */
    @Autowired
    private LabelRepository labelRepository;

    /**
     * CloneRepository used to retrieve and store Clones into the Database.
     */
    @Autowired
    private CloneRepository cloneRepository;
    /**
     * LabelRecognizerService to determine Label classes at runtime.
     */
    @Autowired
    private LabelRecognizerService labelRecognizerService;
    /**
     * Location Repository used to retrieve and store Location into the Database.
     */
    @Autowired
    private NepenthesManagementMetaDataService managementMetaDataService;

    /**
     * Method Implementation to create a new IVClone using a subclass of Label.
     *
     * @param label            any Subclass of a Label
     * @param cloneId          the unique Id of a clone
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param producerAsString the IV Seller of the clone
     * @return IVClone object corresponding to the right Label
     */
    @Override
    public IVClone saveIVClone(final Label label, final String cloneId,
                               final String sexAsString, final String locationAsString,
                               final String producerAsString) {
        IVClone newIvClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Producer producer = this.managementMetaDataService.getProducer(producerAsString);

        // only Location is allowed to be freely inserted
        Location location = this.managementMetaDataService.saveLocation(locationAsString);
        if (this.cloneRepository.existsByInternalCloneId(IVClone.generateInternalCloneId(cloneId, sex))) {
            return null;
        }
        newIvClone = label.addIVClone(cloneId, sex, location, producer);
        this.labelRepository.save(label);
        return newIvClone;


    }


    /**
     * Method Implementation to create a new ICClone using a subclass of Label.
     *
     * @param label            any Subclass of a Label
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param sellerAsString   the (private) seller of a IC clone
     * @return ICCLone object corresponding to the right Label
     */

    @Override
    public ICClone saveICClone(final Label label, final String sexAsString,
                               final String locationAsString, final String sellerAsString) {
        Location location;
        ICClone newIcClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Seller seller = this.managementMetaDataService.getSeller(sellerAsString);
        location = this.managementMetaDataService.saveLocation(locationAsString);
        newIcClone = label.addICClone(sex, location, seller);
        this.labelRepository.save(label);
        return newIcClone;
    }

    /**
     * Method Implementation to create a new ICClone with a specific cloneId
     * using a subclass of Label.
     *
     * @param label            any Subclass of a Label
     * @param cloneId          the unique Id of a clone
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param sellerAsString   the IV Seller of the clone
     * @return ICCLone object corresponding to the right Label
     */

    @Override
    public ICClone saveICCloneWithCloneId(final Label label, final String cloneId,
                                          final String sexAsString,
                                          final String locationAsString,
                                          final String sellerAsString) {
        Location location;
        ICClone newIcClone;
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Seller seller = this.managementMetaDataService.getSeller(sellerAsString);
        location = this.managementMetaDataService.saveLocation(locationAsString);
        if (this.cloneRepository.existsByInternalCloneId(ICClone.generateInternalCloneId(cloneId, sex))) {
            return null;
        }

        newIcClone = label.addICClone(sex, cloneId, location, seller);
        this.labelRepository.save(label);

        return newIcClone;
    }

    /**
     * Method Implementation to create a new IVClone
     * using a subclass of Label determined at runtime.
     *
     * @param labelName        name of the Label to determine the concrete Label class
     * @param cloneId          the unique Id of a clone
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param producerAsString name of the producer
     * @return IVClone object corresponding to the right Label
     */

    @Override
    public IVClone saveIVClone(final String labelName, final String cloneId,
                               final String sexAsString, final String locationAsString,
                               final String producerAsString) {
        Label label = this.labelRecognizerService.returnRightLabelClass(labelName);
        if (label != null) {
            label = this.createLabel(label);
            return this.saveIVClone(label, cloneId, sexAsString, locationAsString, producerAsString);
        }
        return null;
    }

    /**
     * Method Implementation to create a new ICClone
     * using a subclass of Label determined at runtime.
     *
     * @param labelName        name of the Label to determine the concrete Label class
     * @param sexAsString      the sex of a clone
     * @param locationAsString the origin of the clone
     * @param sellerAsString   name of the seller
     * @return IVClone object corresponding to the right Label
     */

    @Override
    public ICClone saveICClone(final String labelName, final String sexAsString,
                               final String locationAsString, final String sellerAsString) {
        Label label = this.labelRecognizerService.returnRightLabelClass(labelName);
        if (label != null) {
            label = this.createLabel(label);
            return this.saveICClone(label, sexAsString, locationAsString, sellerAsString);
        }
        return null;
    }

    /**
     * Method Implementation to store a Label into the Database.
     *
     * @param label concrete Label to store into the Database
     * @return concrete Label object stored in the Database
     */

    @Override
    public Label createLabel(final Label label) {
        Label rLabel = this.labelRepository.findLabelByName(label.getName());
        if (rLabel != null) {
            return rLabel;
        }
        int labelCount = this.getLabelCount(label.getClass().getSimpleName());

        label.setPrefixIfEmpty(labelCount);
        return this.labelRepository.save(label);
    }

    /**
     * Method Implementation to retrieve the Amount of different subclass Labels.
     *
     * @param className Name of the (subclass) Label
     * @return amount of different (subclass) Label
     */

    @Override
    public int getLabelCount(final String className) {
        return this.labelRepository.countLabelByLabelClass(className);
    }

    /**
     * Method Implementation to create for an existing unknown clone an identical sexed clone
     * This Method is used in the Frontend for Growlist in order be able to change
     * the Sex of at first unknown sexed clone.
     *
     * @param clone       clone to clone
     * @param sexAsString sex of the clone to clone
     * @return sexed clone
     * @throws CloneAlreadyHasASex if Clone with sex already exists
     */
    @Override
    @Transactional("transactionManager")
    public Clone getOrCreateSexedClone(final Clone clone, final String sexAsString) throws CloneAlreadyHasASex {
        Sex sex = this.managementMetaDataService.getSex(sexAsString);
        Clone rClone = this.cloneRepository.findCloneByInternalCloneId(Clone.generateInternalCloneId(clone.getCloneId(), sex));
        if (rClone != null) {
            return rClone;
        }

        if (clone instanceof IVClone) {
            return this.saveIVClone(clone.getLabel(), clone.getCloneId(), sexAsString, clone.getLocationAsString(), clone.getSellerAsString());
        }
        // if the clone is IC and already has a sex, we won´t allow to change it
        if (clone.getSex() != null) {
            throw new CloneAlreadyHasASex(clone.getSexAsString());
        }

        clone.setSex(sex);
        this.cloneRepository.save(clone);
        return clone;


    }


}
