package com.nepflow.UserManagement.Service;


import com.nepflow.UserManagement.Exception.CouldNotGenerateAuth0TokenException;
import com.nepflow.UserManagement.Exception.CouldNotReachAuth0Endpoint;
import com.nepflow.UserManagement.Exception.CouldNotRetrieveAuth0UserException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Service used to communicate with small subset of Auth0 endpoints.
 *
 * @author David Schmidt
 * @version 26. Oct 2024
 */

public interface Auth0UserService {


    /**
     * @param oauthId oauthId of the user
     * @return Email from of the user
     */
    String getUserEmail(String oauthId) throws CouldNotRetrieveAuth0UserException, CouldNotReachAuth0Endpoint;


    /**
     * @param oauthIds ids of the users
     * @return hashmap with userid as key and email as value
     * @throws CouldNotRetrieveAuth0UserException
     * @throws CouldNotReachAuth0Endpoint
     */
    HashMap<String, String> getUserEmails(List<String> oauthIds) throws CouldNotRetrieveAuth0UserException, CouldNotReachAuth0Endpoint;

    /**
     * Method definition for the actual REST Call to the Endpoint.
     *
     * @param url absolute url of Auth0 to request
     * @return Response as String
     */
    JSONObject makeRequest(String url) throws CouldNotRetrieveAuth0UserException, CouldNotReachAuth0Endpoint;

    /**
     * @return accessToken to read users from auth0
     */
    JSONObject generateNewToken() throws CouldNotGenerateAuth0TokenException, CouldNotReachAuth0Endpoint;

    /**
     * @param token jwt Token String to be validated
     * @return true if Token is valid and not expired
     */
    boolean validateToken(String token);

    /**
     * @return current token if valid or a new one
     */
    String getValidToken() throws CouldNotGenerateAuth0TokenException, CouldNotReachAuth0Endpoint;


    /**
     * @param email   new email address
     * @param oauthId id of the user
     * @return
     */
    boolean updateUserEmail(String email, String oauthId);


    /**
     * @param oauthId id of the user
     * @param email   email of the user
     */
    void updateCache(String oauthId, String email);

    /**
     * @param users hashmap with id as key and email as value
     */
    void updateCache(HashMap<String, String> users);

    /**
     * @return Hashmap containing all users with oauthId as key and email as value
     */
    HashMap<String, String> getUserCache();


}
