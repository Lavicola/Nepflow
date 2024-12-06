package com.nepflow.UserManagement.Service;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserRetrievalServiceImpl implements UserRetrievalService {


    /**
     *
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(final String username) {
        return this.userRepository.findUserByUsername(username);
    }

    /**
     * @param oauthId
     * @return
     */
    @Override
    public User getUserByOAuthId(final String oauthId) {
        return this.userRepository.findUserByOAuthId(oauthId);

    }
}
