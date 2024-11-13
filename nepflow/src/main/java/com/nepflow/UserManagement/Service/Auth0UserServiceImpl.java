package com.nepflow.UserManagement.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nepflow.UserManagement.Exception.CouldNotGenerateAuth0TokenException;
import com.nepflow.UserManagement.Exception.CouldNotReachAuth0Endpoint;
import com.nepflow.UserManagement.Exception.CouldNotRetrieveAuth0UserException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;


/**
 * Service used to communicate with small subset of Auth0 endpoints.
 *
 * @author David Schmidt
 * @version 26. Oct 2024
 */


@Service
public class Auth0UserServiceImpl implements Auth0UserService {

    /**
     *
     */
    @Value("${nepflow.basemodules.auth-user-service.clientId}")

    private String clientId;

    /**
     *
     */
    @Value("${nepflow.basemodules.auth-user-service.audience}")

    private String audience;

    /**
     *
     */
    @Value("${nepflow.basemodules.auth-user-service.clientSecret}")
    private String clientSecret;

    /**
     *
     */
    @Value("${nepflow.basemodules.auth-user-service.get-token-url}")
    private String accessTokenUrl;

    /**
     * public Key to validate jwt Token.
     */
    @Value("nepflow.basemodules.auth-user-service.public-key")
    private String publicKeyAsString = "";


    /**
     * Cache containing all Emails which were already requested.
     */
    private final HashMap<String, String> userCache = new HashMap<>();


    /**
     * current (valid) Token.
     */
    private JSONObject currentToken = null;

    /**
     *
     */
    private PublicKey publicKey;


    /**
     * contains the hardcoded string used to access the information how long the
     * Token is valid of the JSON response from auth0.
     */
    private static final String EXPIRES_KEY = "expires_in";

    /**
     * contains the hardcoded string used to access the Token
     * of the JSON response from auth0.
     */
    private static final String ACCESS_TOKEN_KEY = "access_token";


    /**
     * @param publicKeyAsString
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public Auth0UserServiceImpl(final @Value("${nepflow.basemodules.auth-user-service.public-key}") String publicKeyAsString) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] publicBytes = Base64.decodeBase64(publicKeyAsString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        this.publicKey = keyFactory.generatePublic(keySpec);

    }


    /**
     * This Method return the User from the UserCache or if non-existent from the endpoint.
     *
     * @param oauthId oauthId of the user
     * @return JSON Object contains the response of the auth0 endpoint
     */
    @Override
    public String getUserEmail(final String oauthId) throws CouldNotRetrieveAuth0UserException, CouldNotReachAuth0Endpoint {
        JSONObject response;
        String email;
        if (this.userCache.containsKey(oauthId)) {
            return this.userCache.get(oauthId);
        }
        String url = String.format("%susers?q=user_id:%s&fields=email,user_id&include_fields=true&search_engine=v3&include_totals=true",
                this.audience, oauthId).replace("|", "%7C");
        response = this.makeRequest(url);
        email = this.extractUserEmails(response).get(oauthId);
        this.updateCache(oauthId, email);
        return email;
    }


    /**
     * @param oauthIds ids of the users
     * @return hashmap with userid as key and email as value
     * @throws CouldNotRetrieveAuth0UserException
     * @throws CouldNotReachAuth0Endpoint
     */
    @Override
    public HashMap<String, String> getUserEmails(final List<String> oauthIds) throws CouldNotRetrieveAuth0UserException, CouldNotReachAuth0Endpoint {
        HashMap<String, String> userMap = new HashMap<String, String>();
        JSONObject response;
        if (oauthIds.isEmpty()) {
            return userMap;
        }
        if (oauthIds.size() == 1) {
            String email = this.getUserEmail(oauthIds.get(0));
            userMap.put(oauthIds.get(0), email);
            return userMap;
        } else {
            StringBuilder url = new StringBuilder(String.format("%susers?q=user_id:%s", this.audience, oauthIds.get(0)));
            for (int i = 1; i < oauthIds.size(); i++) {
                url.append("%20OR%20user_id:").append(oauthIds.get(i));
            }
            url = new StringBuilder(url.toString().replace("|", "%7C"));
            url = new StringBuilder(String.format("%s&fields=email,user_id&include_fields=true&search_engine=v3&include_totals=true", url.toString()));
            response = this.makeRequest(url.toString());
            userMap = this.extractUserEmails(response);
            this.updateCache(userMap);
        }


        return userMap;
    }


    /**
     * @param response response which was received in using
     *                 "fields=email,user_id&include_fields=true&search_engine=v3&include_totals=true" within the query
     * @return HashMap with oAuthId as Key and email as value
     */
    private HashMap<String, String> extractUserEmails(final JSONObject response) {
        HashMap<String, String> userMap = new HashMap<>();
        if (response.keySet().contains("total")
                && Integer.parseInt(response.get("total").toString()) <= 0
                && response.keySet().contains("users")
        ) {
            return userMap;
        }
        JSONArray jsonArray = (JSONArray) response.get("users");
        for (Object object : jsonArray) {
            JSONObject user;
            if (object instanceof JSONObject) {
                user = (JSONObject) object;
                userMap.put(user.getString("user_id"), user.getString("email"));

            }

        }

        return userMap;
    }


    /**
     * Method used to call the actual Endpoint
     *
     * @param url absolute url of Auth0 to request
     * @return
     * @throws CouldNotRetrieveAuth0UserException
     * @throws CouldNotReachAuth0Endpoint
     */
    public JSONObject makeRequest(final String url) throws CouldNotRetrieveAuth0UserException, CouldNotReachAuth0Endpoint {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url)
                    .header("authorization", String.format("Bearer %s", this.getValidToken()))
                    .asJson();
        } catch (UnirestException e) {
            throw new CouldNotReachAuth0Endpoint(e.getMessage());
        }
        if (response.getStatus() != 200) {
            throw new CouldNotReachAuth0Endpoint(response.getBody().toString());
        }
        return response.getBody().getObject();

    }


    /**
     * returns a valid Token by either calling the endpoint or using the current Token if still valid.
     *
     * @return valid Token
     */
    public String getValidToken() throws CouldNotGenerateAuth0TokenException, CouldNotReachAuth0Endpoint {
        String jwtString = null;
        if (this.currentToken == null) {
            this.currentToken = this.generateNewToken();
        }

        try {
            jwtString = this.currentToken.get(ACCESS_TOKEN_KEY).toString();
        } catch (JSONException e) {
            throw new CouldNotGenerateAuth0TokenException(e.getMessage());
        }

        if (jwtString != null && this.validateToken(jwtString)) {
            return jwtString;
        }
        throw new CouldNotGenerateAuth0TokenException("Token is not valid");

    }


    /**
     * @param token jwt Token String to be validated
     * @return true if jwt token could be verified AND is not expired
     */
    public boolean validateToken(final String token) {
        Claims claims;
        ZonedDateTime currentTime;
        ZonedDateTime tokenExpiration;
        String expiration;
        Instant currentInstant;
        Instant tokenInstant;

        claims = Jwts.parser().verifyWith((this.publicKey))
                .build().parseSignedClaims(token).getPayload();
        expiration = claims.get("exp").toString();
        currentInstant = Instant.now();
        tokenInstant = Instant.ofEpochSecond(Long.parseLong(expiration));

        currentTime = ZonedDateTime.ofInstant(currentInstant, ZoneId.systemDefault());
        tokenExpiration = ZonedDateTime.ofInstant(tokenInstant, ZoneId.systemDefault());

        return currentTime.isBefore(tokenExpiration);

    }


    /**
     * makes a request to the Auth0 endpoint to generate a new Token.
     *
     * @return accessToken to read users from auth0
     */
    @Override
    public JSONObject generateNewToken() throws CouldNotGenerateAuth0TokenException, CouldNotReachAuth0Endpoint {
        HttpResponse<JsonNode> response = null;
        String token = null;
        String accessTokenRequestUrl = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s&audience=%s",
                this.clientId, this.clientSecret, this.audience);
        try {
            response = Unirest.post(this.accessTokenUrl)
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body(
                            accessTokenRequestUrl)
                    .asJson();
        } catch (UnirestException e) {
            throw new CouldNotReachAuth0Endpoint(e.getMessage());
        }
        if (response.getStatus() != 200) {
            throw new CouldNotGenerateAuth0TokenException(response.getBody().toString());
        }

        return response.getBody().getObject();
    }

    /**
     * TODO.
     *
     * @param email   new email address
     * @param oauthId id of the user
     * @return false
     */
    public boolean updateUserEmail(final String email, final String oauthId) {
        return false;
    }

    /**
     * @param oauthId id of the user
     * @param email   email of the user
     */
    @Override
    public void updateCache(final String oauthId, final String email) {

        if (this.userCache.containsKey(oauthId)) {
            // TODO
            System.out.println("TODO logging");
        }
        this.userCache.put(oauthId, email);


    }

    /**
     * @param users hashmap with id as key and email as value
     */
    @Override
    public void updateCache(final HashMap<String, String> users) {
        users.forEach(this::updateCache);

    }

    /**
     * @return Hashmap containing all users with oauthId as key and email as value
     */
    @Override
    public HashMap<String, String> getUserCache() {
        return new HashMap<>(this.userCache);
    }


}
