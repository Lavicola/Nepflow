package com.nepflow.Service;

import com.nepflow.Models.User;
import com.nepflow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User createMinimalUser(String OAuthId) {
        // user_Id (provide|unique id) is unique https://auth0.com/docs/manage-users/user-accounts/identify-users
        User user = this.userRepository.findUserByOAuthId(OAuthId);
        if (user == null) {
            return user;
        }
        user = new User();
        user.setOAuthId(OAuthId);
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(String OAuthId, User user) {
        User toUpdateUser = this.userRepository.findUserByOAuthId(OAuthId);
        if (toUpdateUser == null) {
            return null;
        }
        // only allow username change if no Username exists
        if(toUpdateUser.getUsername() == null){
            toUpdateUser.setUsername(user.getUsername());
        }
        toUpdateUser.setContactInformation(user.getContactInformation());


        return null;
    }
}
