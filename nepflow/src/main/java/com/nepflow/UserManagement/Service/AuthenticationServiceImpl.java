package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;


    public User getAuthenticatedUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return null;
        }
        return this.userRepository.findUserByOAuthId(authentication.getName());
    }

    @Override
    public String getOauthId() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return null;
        }
        return authentication.getName();
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }


}
