package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Event.UserCreatedEvent;
import com.nepflow.UserManagement.Model.Country;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.CountryRepository;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public User getUserByOAuthId(String oauthId) {
        return this.userRepository.findUserByOAuthId(oauthId);

    }

    @Override
    public boolean isUsernameFree(String username) {
        return this.userRepository.isUsernameFree(username);
    }

    @Override
    public User createMinimalUser(User user, String countryName) {
        // user_Id (provide|unique id) is unique https://auth0.com/docs/manage-users/user-accounts/identify-users
        if (this.userRepository.existsUserByOAuthId(user.getOAuthId())) {
            return user;
        }
        Country country = this.countryRepository.findCountryByName(countryName);
        user.setCountry(country);
        this.userRepository.save(user);
        applicationEventPublisher.publishEvent(new UserCreatedEvent(this,user));
        return user;
    }

    @Override
    @Transactional("transactionManager")
    public User updateUser(User user) {
        User toUpdateUser = this.userRepository.findUserByOAuthId(user.getOAuthId());
        if (toUpdateUser == null) {
            return null;
        }
        // only allow username change if no Username exists
        if (toUpdateUser.getUsername() == null && this.isUsernameFree(user.getUsername())) {
            toUpdateUser.setUsername(user.getUsername());
        }
        //toUpdateUser.setContactInformation(user.getContactInformation());
        this.userRepository.save(toUpdateUser);
        return toUpdateUser;
    }


}
