package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Service which implements a small set of Methods used to retrieve
 * authenticated user.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     *
     */
    @Autowired
    private UserRepository userRepository;


    /**
     * Using the SecurityContextHolder, the method uses the oAuthId of the jwt token.
     * Using this Information the current User can be retrieved from the database.
     *
     * @return current User
     */
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return this.userRepository.findUserByOAuthId(authentication.getName());
    }

    /**
     * @return current oAuthId
     */
    @Override
    public String getOauthId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }


}
