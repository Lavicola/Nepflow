package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.NepenthesClone;
import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.UserManagement.Model.User;

import java.util.List;

public interface GrowListService {

    NepenthesClone addNepenthesCloneToUser(String cloneId, String nepenthesName, User user);
    List<NepenthesClone> getNepenthesOfUser(User user);


}
