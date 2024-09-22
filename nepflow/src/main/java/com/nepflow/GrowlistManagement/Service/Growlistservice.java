package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.UserManagement.Model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Model which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */


public interface Growlistservice {

    /**
     * @param user User for which a new Growlist shall be created
     */
    void createGrowlist(User user);

    /**
     * @param username username of the User to
     * @return Growlist
     */
    Growlist getGrowlist(String username);

    /**
     * @param user            User which will be referenced in the created Specimen
     * @param internalCloneId clone (primary key) which will be referenced in the created Specimen
     * @return Specimen
     */
    Specimen addExistingCloneToGrowList(User user, String internalCloneId);


    /**
     * @param user             User which will be referenced in the created Specimen
     * @param internalCloneIds clones (primary key) which will be referenced in the created Specimens
     * @return Specimen
     */
    List<Specimen> addExistingClonesToGrowlist(User user, List<String> internalCloneIds);

    /**
     * @param user             User which will be referenced in the created Specimen
     * @param labelName        name to retrieve the corresponding Label for the clone reference
     * @param cloneId          id of the clone
     * @param sexAsString      sex of the clone
     * @param locationAsString location of the clone
     * @param producerAsString producer name of the clone
     * @return Specimen
     */
    Specimen addNewIVCloneToGrowList(User user, String labelName, String cloneId, String sexAsString,
                                     String locationAsString, String producerAsString);

    /**
     * @param user             User which will be referenced in the created Specimen
     * @param labelName        name to retrieve the corresponding Label for the clone reference
     * @param cloneId          id of the clone
     * @param sexAsString      sex of the clone
     * @param locationAsString location of the clone
     * @param sellerAsString   seller name of the clone
     * @return Specimen
     */
    Specimen addNewICCloneToGrowList(User user, String labelName, String cloneId,
                                     String sexAsString,
                                     String locationAsString, String sellerAsString);

    /**
     * @param oAuthId       id(primary key) of the user
     * @param specimenId    specimen id (primary key) of the specimen
     * @param multipartFile file containing image and metadata
     * @return true if success, else false
     */
    boolean updateSpecimenImage(String oAuthId, String specimenId, MultipartFile multipartFile);

    /**
     * @param user        User which initiated the request
     * @param specimenId  id(primary key) of the specimen to change the flower status
     * @param isFlowering true if flowering, else false
     * @return true if success, else false
     */
    boolean updateFlowerStatus(User user, String specimenId, boolean isFlowering);

    /**
     * @param oAuthId     id(primary key) of the user
     * @param specimenId  id(primary key) of the specimen to change the flower status
     * @param sexAsString sex as String value
     * @return true if success, else false
     */
    boolean updateSex(String oAuthId, String specimenId, String sexAsString);

    /**
     * @param oAuthId    id(primary key) of the user which initiated the request
     * @param growlistId id(primary key) of the growlist
     * @param isPublic   true if public, false for private
     * @return true if success, else false
     */
    boolean updateGrowlistVisibility(String oAuthId, String growlistId, boolean isPublic);

    /**
     * @param user       User which initiated the request
     * @param specimenId id(primary key of the Specimen)
     * @return true if success, else false
     */
    boolean deleteSpecimenFromGrowlist(User user, String specimenId);


}
