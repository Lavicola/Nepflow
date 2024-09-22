package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;

/**
 * Service which defines a small set of Methods used to retrieve
 * authenticated user.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

public interface AuthenticationService {


    /**
     * @return current authenticated user
     */
    User getAuthenticatedUser();

    /**
     * @return oAuthId of the current User
     */
    String getOauthId();


}
