package com.nepflow.UserManagement.TokenService;

import com.nepflow.UserManagement.Model.User;

/**
 * A Generic Token Service
 */

public interface TokenService {


    // generate, return and store Token
     String generateAndStoreToken(User user);
    // check the signature
     boolean isAuthentic(String token);
    // check if Token is still valid
     boolean isTokenExpired(String token);
    // delete Token
     boolean deleteToken(String token,User user);
    // check if the Token is identical with the Token in the Database, since there can be only one active Token
     boolean isCurrentToken(String token,User user);

     String extractUsername(String token);
}
