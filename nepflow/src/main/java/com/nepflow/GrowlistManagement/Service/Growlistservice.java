package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.UserManagement.Model.User;
import org.springframework.web.multipart.MultipartFile;

public interface Growlistservice {

     void createGrowlist(User user);

     Growlist getGrowlist(String username);

    // If Clone already exists, only nepenthesRetrivalService is necessary to add a Clone to a Growlist
     Specimen addExistingCloneToGrowList(User user, String internalCloneId);


    // Both Methods need to access the NepenthesManagementService in order to create a Clone first
    // If Resource are of no concern, it is recommended to do two Requests in Frontend to avoid this loose coupling
     Specimen addNewIVCloneToGrowList(User user,String labelName,String cloneId,
                                            String sexAsString,
                                            String locationAsString, String producerAsString);

     Specimen addNewICCloneToGrowList(User user,String labelName,String cloneId,
                                            String sexAsString,
                                            String locationAsString, String sellerAsString);

     boolean updateSpecimenImage(String OAuthId, String specimenId, MultipartFile multipartFile);

    boolean updateFlowerStatus(User user, String specimenId, boolean isFlowering);

    boolean updateSex(String OAuthId, String specimenId,String sexAsString);

    boolean updateGrowlistVisibility(String OAuthId, String growlistId,boolean isPublic);

    boolean deleteSpecimenFromGrowlist(String OAuthId, String specimenId);

    boolean belongsSpecimenToUser(String specimenId,String userId);

}
