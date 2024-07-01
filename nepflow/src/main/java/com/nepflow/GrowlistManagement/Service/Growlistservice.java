package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.UserManagement.Model.User;

public interface Growlistservice {

    public void createGrowlist(User user);

    public Growlist getGrowlist(String username);

    // If Clone already exists, only nepenthesRetrivalService is necessary to add a Clone to a Growlist
    public Specimen addExistingCloneToGrowList(User user, String internalCloneId);


    // Both Methods need to access the NepenthesManagementService in order to create a Clone first
    // If Resource are of no concern, it is recommended to do two Requests in Frontend to avoid this loose coupling
    public Specimen addNewIVCloneToGrowList(User user,String labelName,String cloneId,
                                            String sexAsString,
                                            String locationAsString, String producerAsString);

    public Specimen addNewICCloneToGrowList(User user,String labelName,String cloneId,
                                            String sexAsString,
                                            String locationAsString, String sellerAsString);



}
