package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;

public interface UserRetrievalService {

    /**
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * @param oauthId
     * @return
     */
    User getUserByOAuthId(String oauthId);


}
