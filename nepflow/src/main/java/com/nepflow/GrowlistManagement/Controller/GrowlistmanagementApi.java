/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Dto.CloneType;
import com.nepflow.GrowlistManagement.Dto.GrowlistDTO;
import com.nepflow.GrowlistManagement.Dto.LabelCloneDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-01T18:41:42.843846800+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Validated
@Tag(name = "Growlistmanagement", description = "the Growlistmanagement API")
public interface GrowlistmanagementApi {

    default GrowlistmanagementApiDelegate getDelegate() {
        return new GrowlistmanagementApiDelegate() {};
    }

    /**
     * POST /growlist/clone/add/{internalCloneId} : Add an existing Clone of a Nepenthes to the Growlist.
     *
     * @param internalCloneId  (required)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     */
    @Operation(
        operationId = "growlistCloneAddInternalCloneIdPost",
        summary = "Add an existing Clone of a Nepenthes to the Growlist.",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecimenCloneDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error, could not add Specimen to user")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/growlist/clone/add/{internalCloneId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<SpecimenCloneDTO> growlistCloneAddInternalCloneIdPost(
        @Parameter(name = "internalCloneId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("internalCloneId") String internalCloneId
    ) {
        return getDelegate().growlistCloneAddInternalCloneIdPost(internalCloneId);
    }


    /**
     * POST /growlist/clone/create/{cloneType} : Create a new IV or IC Clone and Add it to the Growlist
     *
     * @param cloneType  (required)
     * @param labelCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     */
    @Operation(
        operationId = "growlistCloneCreateCloneTypePost",
        summary = "Create a new IV or IC Clone and Add it to the Growlist",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecimenCloneDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error, could not add Specimen to user")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/growlist/clone/create/{cloneType}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecimenCloneDTO> growlistCloneCreateCloneTypePost(
        @Parameter(name = "cloneType", description = "", required = true, in = ParameterIn.PATH) @PathVariable("cloneType") CloneType cloneType,
        @Parameter(name = "LabelCloneDTO", description = "") @Valid @RequestBody(required = false) LabelCloneDTO labelCloneDTO
    ) {
        return getDelegate().growlistCloneCreateCloneTypePost(cloneType, labelCloneDTO);
    }


    /**
     * DELETE /growlist/clones/{specimenId} : remove a clone from the growlisti If the removed plant was already used for a trade it will be a soft delete in the relation part
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     *         or Error, could not add Nepenthes Clone to user (status code 500)
     */
    @Operation(
        operationId = "growlistClonesSpecimenIdDelete",
        summary = "remove a clone from the growlisti If the removed plant was already used for a trade it will be a soft delete in the relation part",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Error, could not add Nepenthes Clone to user")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/growlist/clones/{specimenId}"
    )
    
    default ResponseEntity<Void> growlistClonesSpecimenIdDelete(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId
    ) {
        return getDelegate().growlistClonesSpecimenIdDelete(specimenId);
    }


    /**
     * PUT /growlist/clones/{specimenId} : update values
     *
     * @param specimenId  (required)
     * @param specimenCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Could not update Specimen (status code 500)
     */
    @Operation(
        operationId = "growlistClonesSpecimenIdPut",
        summary = "update values",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecimenCloneDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Could not update Specimen")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/growlist/clones/{specimenId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecimenCloneDTO> growlistClonesSpecimenIdPut(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId,
        @Parameter(name = "SpecimenCloneDTO", description = "") @Valid @RequestBody(required = false) SpecimenCloneDTO specimenCloneDTO
    ) {
        return getDelegate().growlistClonesSpecimenIdPut(specimenId, specimenCloneDTO);
    }


    /**
     * GET /growlist/{username}/clones : get Nepenthes of a specific User
     *
     * @param username  (required)
     * @return OK (status code 200)
     *         or Error, User not found (status code 404)
     */
    @Operation(
        operationId = "growlistUsernameClonesGet",
        summary = "get Nepenthes of a specific User",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GrowlistDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Error, User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/growlist/{username}/clones",
        produces = { "application/json" }
    )
    
    default ResponseEntity<GrowlistDTO> growlistUsernameClonesGet(
        @Parameter(name = "username", description = "", required = true, in = ParameterIn.PATH) @PathVariable("username") String username
    ) {
        return getDelegate().growlistUsernameClonesGet(username);
    }

}
