package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;


public interface AuthenticationService {


    public User getAuthenticatedUser();
    public String getOauthId();
    // TODO does not belong here, better introduce retrieval Service
    public User getUserByUsername(String username);


}
