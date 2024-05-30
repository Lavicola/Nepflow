package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;

import java.util.List;

public interface UserManagementService {

    public List<User> getAllUsers();

    public User getUserByUsername(String username);

    public User getUserByOAuthId(String oauthId);

    public boolean isUsernameFree(String username);

    public User createMinimalUser(User user, String countryName);

    public User updateUser(User user);

}
