package com.nepflow.UserManagement.service;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.UserRepository;
import com.nepflow.UserManagement.Repository.VerificationTokenRepository;
import com.nepflow.UserManagement.TokenService.TokenServiceEmailImpl;
import com.nepflow.UserManagement.TokenService.TokenServicePasswordResetImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserEmailService userEmailService;

    @Autowired
    TokenServiceEmailImpl tokenServiceEmail;

    @Autowired
    TokenServicePasswordResetImpl tokenServicePasswordReset;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;


    @Override
    public boolean createUserLocked(String email, String username, String password, String contactInformation) {

        if (this.userRepository.findUserByEmailOrUsername(email, username).isPresent()) {
            System.out.println("FOUND YOU");
            return false;
        }
        User newUser = new User(email, username, password, contactInformation);
        String token = tokenServiceEmail.generateAndStoreToken(newUser);
        this.userEmailService.sendVerificationEmail(email, username, token);
        this.userRepository.save(newUser);

        return false;

    }

    @Override
    public boolean enableUser(String token) {
        String username;

        if (!this.tokenServiceEmail.isAuthentic(token)) {
            return false;
        }
        if (this.tokenServiceEmail.isTokenExpired(token)) {
            return false;
        }
        username = this.tokenServiceEmail.extractUsername(token);
        Optional<User> user = this.userRepository.findByUsername(username);
        if (user.isPresent() && this.tokenServiceEmail.isCurrentToken(token, user.get())) {
            user.get().setEnabled(true);
            this.userRepository.save(user.get());
            this.tokenServiceEmail.deleteToken(token, user.get());
            return true;
        }
        return false;
    }
}
