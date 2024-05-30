/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nepflow.UserManagement.Controller;

import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Dto.UserPrivacyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-01T19:01:53.601610227+02:00[Europe/Berlin]")
@Validated
@Tag(name = "Usermanagement", description = "Operations to manage and retrive Users")
public interface UsermanagementApi {

    default UsermanagementApiDelegate getDelegate() {
        return new UsermanagementApiDelegate() {};
    }

    /**
     * GET /user : return current User.
     *
     * @return User exists. (status code 200)
     *         or User not found (status code 404)
     */
    @Operation(
        operationId = "userGet",
        summary = "return current User.",
        tags = { "Usermanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User exists.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user",
        produces = { "application/json" }
    )
    default ResponseEntity<UserDTO> userGet(
        
    ) {
        return getDelegate().userGet();
    }


    /**
     * POST /user : Create an User in the Application with minimal sensitive Information.
     *
     * @param userDTO empty body (required)
     * @return Profile created successfully. (status code 201)
     *         or Error (status code 204)
     */
    @Operation(
        operationId = "userPost",
        summary = "Create an User in the Application with minimal sensitive Information.",
        tags = { "Usermanagement" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Profile created successfully.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> userPost(
        @Parameter(name = "UserDTO", description = "empty body", required = true) @Valid @RequestBody UserDTO userDTO
    ) {
        return getDelegate().userPost(userDTO);
    }


    /**
     * PUT /user : Update Information of User
     *
     * @param userDTO User DTO with all changeable values (required)
     * @return Profile change successfully. (status code 201)
     *         or Error (status code 204)
     */
    @Operation(
        operationId = "userPut",
        summary = "Update Information of User",
        tags = { "Usermanagement" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Profile change successfully."),
            @ApiResponse(responseCode = "204", description = "Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/user",
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> userPut(
        @Parameter(name = "UserDTO", description = "User DTO with all changeable values", required = true) @Valid @RequestBody UserDTO userDTO
    ) {
        return getDelegate().userPut(userDTO);
    }


    /**
     * GET /users : get all Users
     *
     * @return OK (status code 200)
     *         or No Information found for User (status code 404)
     */
    @Operation(
        operationId = "usersGet",
        summary = "get all Users",
        tags = { "Usermanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserPrivacyDTO.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No Information found for User")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users",
        produces = { "application/json" }
    )
    default ResponseEntity<List<UserPrivacyDTO>> usersGet(
        
    ) {
        return getDelegate().usersGet();
    }


    /**
     * GET /users/{username} : get Userinformation
     *
     * @param username  (required)
     * @return OK (status code 200)
     *         or No Information found for User (status code 404)
     */
    @Operation(
        operationId = "usersUsernameGet",
        summary = "get Userinformation",
        tags = { "Usermanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserPrivacyDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "No Information found for User")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users/{username}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserPrivacyDTO> usersUsernameGet(
        @Parameter(name = "username", description = "", required = true, in = ParameterIn.PATH) @PathVariable("username") String username
    ) {
        return getDelegate().usersUsernameGet(username);
    }

}
