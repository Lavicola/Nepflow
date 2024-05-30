package com.nepflow.UserManagement.Controller;

import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Dto.UserPrivacyDTO;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link UsermanagementApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-01T19:01:53.601610227+02:00[Europe/Berlin]")
public interface UsermanagementApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /user : return current User.
     *
     * @return User exists. (status code 200)
     *         or User not found (status code 404)
     * @see UsermanagementApi#userGet
     */
    default ResponseEntity<UserDTO> userGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"country\" : \"country\", \"contactInformation\" : \"contactInformation\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /user : Create an User in the Application with minimal sensitive Information.
     *
     * @param userDTO empty body (required)
     * @return Profile created successfully. (status code 201)
     *         or Error (status code 204)
     * @see UsermanagementApi#userPost
     */
    default ResponseEntity<UserDTO> userPost(UserDTO userDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"country\" : \"country\", \"contactInformation\" : \"contactInformation\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /user : Update Information of User
     *
     * @param userDTO User DTO with all changeable values (required)
     * @return Profile change successfully. (status code 201)
     *         or Error (status code 204)
     * @see UsermanagementApi#userPut
     */
    default ResponseEntity<Void> userPut(UserDTO userDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /users : get all Users
     *
     * @return OK (status code 200)
     *         or No Information found for User (status code 404)
     * @see UsermanagementApi#usersGet
     */
    default ResponseEntity<List<UserPrivacyDTO>> usersGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"country\" : \"country\", \"username\" : \"username\" }, { \"country\" : \"country\", \"username\" : \"username\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /users/{username} : get Userinformation
     *
     * @param username  (required)
     * @return OK (status code 200)
     *         or No Information found for User (status code 404)
     * @see UsermanagementApi#usersUsernameGet
     */
    default ResponseEntity<UserPrivacyDTO> usersUsernameGet(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"country\" : \"country\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
