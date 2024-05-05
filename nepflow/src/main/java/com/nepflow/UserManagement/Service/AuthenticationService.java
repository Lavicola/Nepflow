package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;

public interface AuthenticationService {


    public User getAuthenticatedUser();

    public String getOauthId();

}
