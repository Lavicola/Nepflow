package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.UserManagement.Model.User;

public interface Growlistservice {

    public void createGrowlist(User user);

    public Growlist getGrowListByUser(String userId);

}
