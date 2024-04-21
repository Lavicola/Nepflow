package com.nepflow.Controller;

import com.nepflow.Dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link UserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-21T00:20:18.974799037+02:00[Europe/Berlin]")
public interface UserApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /user : get Userinformation
     *
     * @return OK (status code 200)
     *         or No Information found for User (status code 404)
     * @see UserApi#userGet
     */
    default ResponseEntity<UserDTO> userGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"contactInformation\" : \"contactInformation\", \"region\" : \"region\", \"email\" : \"email\", \"username\" : \"username\" }";
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
     * @see UserApi#userPost
     */
    default ResponseEntity<UserDTO> userPost(UserDTO userDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"contactInformation\" : \"contactInformation\", \"region\" : \"region\", \"email\" : \"email\", \"username\" : \"username\" }";
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
     * @return Profile changed successfully. (status code 201)
     *         or Error (status code 204)
     * @see UserApi#userPut
     */
    default ResponseEntity<Void> userPut(UserDTO userDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
