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

/**
 * Model which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Service
public class UserManagementServiceImpl implements UserManagementService {

    /**
     *
     */
    @Autowired
    private UserRepository userRepository;

    /**
     *
     */
    @Autowired
    private UserRetrievalService userRetrievalService;


    /**
     *
     */
    @Autowired
    private CountryRepository countryRepository;

    /**
     *
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }


    /**
     * @param username
     * @return
     */
    @Override
    public boolean isUsernameFree(final String username) {
        return this.userRepository.isUsernameFree(username);
    }

    /**
     * @param userId
     * @param username
     * @param contactInformation
     * @param countryName
     * @return
     */
    @Override
    public User createMinimalUser(final String userId, final String username,
                                  final String contactInformation, final String countryName) {
        // user_Id (provide|unique id) is unique https://auth0.com/docs/manage-users/user-accounts/identify-users
        User user;
        Country country;
        if (!this.isUsernameFree(username)) {
            return null;
        }
        country = this.getCountry(countryName);
        if (country == null) {
            return null;
        }
        if (this.userRetrievalService.getUserByOAuthId(userId) != null) {
            return null;
        }

        user = new User(username, userId);
        user.setCountry(country);
        user.setContactInformation(contactInformation);
        this.userRepository.save(user);
        applicationEventPublisher.publishEvent(new UserCreatedEvent(this, user.getOAuthId(), user.getUsername()));
        return user;
    }

    /**
     * @param oauthId
     * @param contactInformation
     * @return
     */
    @Override
    @Transactional("transactionManager")
    public User updateUser(final String oauthId, final String contactInformation) {
        User toUpdateUser = this.userRepository.findUserByOAuthId(oauthId);
        if (toUpdateUser == null) {
            return null;
        }

        toUpdateUser.setContactInformation(contactInformation);
        return this.userRepository.save(toUpdateUser);
    }

    /**
     * @param countryAsString
     * @return
     */
    @Override
    public Country saveCountry(final String countryAsString) {
        Country country = this.countryRepository.findCountryByName(countryAsString);
        if (country != null) {
            return country;
        } else {
            return this.countryRepository.save(new Country(countryAsString));
        }
    }

    /**
     * @param countryAsString
     * @return
     */
    @Override
    public Country getCountry(final String countryAsString) {
        return this.countryRepository.findCountryByName(countryAsString);

    }

    /**
     * @return
     */
    @Override
    public List<User> getUsers() {
        return this.userRepository.getAllUsers();
    }


}
