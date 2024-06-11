package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.UserManagement.Model.User;

public interface Growlistservice {

    public void createGrowlist(User user);

    public Specimen addCloneToGrowList(User user,String internalCloneId);

    public Growlist getGrowListByUser(String userId);

}
