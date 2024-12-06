package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.Country;
import com.nepflow.UserManagement.Model.User;

import java.util.List;

/**
 * Model which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

public interface UserManagementService {

    /**
     * @return List of all Users
     */
    List<User> getAllUsers();

    /**
     * @param username
     * @return
     */
    boolean isUsernameFree(String username);

    /**
     * @param userId
     * @param username
     * @param contactInformation
     * @param countryName
     * @return
     */
    User createMinimalUser(String userId, String username, String contactInformation, String countryName);

    /**
     * @param userId
     * @param contactInformation
     * @return
     */
    User updateUser(String userId, String contactInformation);

    /**
     * @param countryAsString
     * @return
     */
    Country saveCountry(String countryAsString);

    /**
     * @param countryAsString
     * @return
     */
    Country getCountry(String countryAsString);


    /**
     * @return
     */
    List<User> getUsers();

}
