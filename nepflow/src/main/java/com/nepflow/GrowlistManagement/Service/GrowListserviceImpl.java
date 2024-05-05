package com.nepflow.GrowlistManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.UserManagement.Model.User;
import org.springframework.stereotype.Service;

@Service
public class GrowListserviceImpl implements GrowListService{


    @Override
    public boolean addNepenthesCloneToUser(Clone clone, User user) {
        return false;
    }
}
