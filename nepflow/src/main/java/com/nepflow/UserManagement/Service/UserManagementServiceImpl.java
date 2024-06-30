package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Event.UserCreatedEvent;
import com.nepflow.UserManagement.Model.Country;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.CountryRepository;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User createMinimalUser(String userId,String username,String contactInformation, String countryName) {
        // user_Id (provide|unique id) is unique https://auth0.com/docs/manage-users/user-accounts/identify-users
        User user;
        Country country;
        if(!this.isUsernameFree(username)){
            return null;
        }
        country = this.getCountry(countryName);
        if(country == null){
            return null;
        }
        if(this.getUserByOAuthId(userId) !=  null){
            return null;
        }

        user = new User(username,userId);
        user.setCountry(country);
        user.setContactInformation(contactInformation);
        this.userRepository.save(user);
        applicationEventPublisher.publishEvent(new UserCreatedEvent(this, user));
        return user;
    }

    @Override
    @Transactional("transactionManager")
    public User updateUser(String oauthId, String contactInformation) {
        User toUpdateUser = this.userRepository.findUserByOAuthId(oauthId);
        if (toUpdateUser == null) {
            return null;
        }

        toUpdateUser.setContactInformation(contactInformation);
        return this.userRepository.save(toUpdateUser);
    }

    @Override
    public Country saveCountry(String countryAsString) {
        Country country = this.countryRepository.findCountryByName(countryAsString);
        if(country != null){
            return country;
        }else{
            return this.countryRepository.save(new Country(countryAsString));
        }
    }
    @Override
    public Country getCountry(String countryAsString) {
        return this.countryRepository.findCountryByName(countryAsString);

    }


}
