/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Dto.CloneType;
import com.nepflow.GrowlistManagement.Dto.GrowlistDTO;
import com.nepflow.GrowlistManagement.Dto.GrowlistPublic;
import com.nepflow.GrowlistManagement.Dto.LabelCloneDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenUpdateFlowerStatus;
import com.nepflow.GrowlistManagement.Dto.SpecimenUpdateSex;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T21:09:45.198252+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Validated
@Tag(name = "Growlistmanagement", description = "Operations for the GrowlistManagement of an user")
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
     * POST /growlist/create/clone/{cloneType} : Create a new IV or IC Clone and Add it to the Growlist
     *
     * @param cloneType  (required)
     * @param labelCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     */
    @Operation(
        operationId = "growlistCreateCloneCloneTypePost",
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
        value = "/growlist/create/clone/{cloneType}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecimenCloneDTO> growlistCreateCloneCloneTypePost(
        @Parameter(name = "cloneType", description = "", required = true, in = ParameterIn.PATH) @PathVariable("cloneType") CloneType cloneType,
        @Parameter(name = "LabelCloneDTO", description = "") @Valid @RequestBody(required = false) LabelCloneDTO labelCloneDTO
    ) {
        return getDelegate().growlistCreateCloneCloneTypePost(cloneType, labelCloneDTO);
    }


    /**
     * POST /growlist/create/nepenthes/{cloneType} : Create a new Nepenthes and an additional IV or IC Clone and Add it to the Growlist
     *
     * @param cloneType  (required)
     * @param labelCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     */
    @Operation(
        operationId = "growlistCreateNepenthesCloneTypePost",
        summary = "Create a new Nepenthes and an additional IV or IC Clone and Add it to the Growlist",
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
        value = "/growlist/create/nepenthes/{cloneType}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecimenCloneDTO> growlistCreateNepenthesCloneTypePost(
        @Parameter(name = "cloneType", description = "", required = true, in = ParameterIn.PATH) @PathVariable("cloneType") CloneType cloneType,
        @Parameter(name = "LabelCloneDTO", description = "") @Valid @RequestBody(required = false) LabelCloneDTO labelCloneDTO
    ) {
        return getDelegate().growlistCreateNepenthesCloneTypePost(cloneType, labelCloneDTO);
    }


    /**
     * PATCH /growlist/{growlistId}/public : set Growlist to public or private
     *
     * @param growlistId  (required)
     * @param growlistPublic  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "growlistGrowlistIdPublicPatch",
        summary = "set Growlist to public or private",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GrowlistPublic.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/growlist/{growlistId}/public",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<GrowlistPublic> growlistGrowlistIdPublicPatch(
        @Parameter(name = "growlistId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("growlistId") String growlistId,
        @Parameter(name = "GrowlistPublic", description = "", required = true) @Valid @RequestBody GrowlistPublic growlistPublic
    ) {
        return getDelegate().growlistGrowlistIdPublicPatch(growlistId, growlistPublic);
    }


    /**
     * GET /growlist/{username}/clones : get all Specimens of a specific User, if Growlist is public
     *
     * @param username  (required)
     * @return OK (status code 200)
     *         or Error, User not found (status code 404)
     */
    @Operation(
        operationId = "growlistUsernameClonesGet",
        summary = "get all Specimens of a specific User, if Growlist is public",
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


    /**
     * DELETE /specimens/{specimenId} : remove a specimen from the growlistist. If the removed plant was already used for a trade, only a soft delete will happen
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     *         or Error, could not add Nepenthes Clone to user (status code 500)
     */
    @Operation(
        operationId = "specimensSpecimenIdDelete",
        summary = "remove a specimen from the growlistist. If the removed plant was already used for a trade, only a soft delete will happen",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Error, could not add Nepenthes Clone to user")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/specimens/{specimenId}"
    )
    
    default ResponseEntity<Void> specimensSpecimenIdDelete(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId
    ) {
        return getDelegate().specimensSpecimenIdDelete(specimenId);
    }


    /**
     * PATCH /specimens/{specimenId}/flowering : Update the flowering status of a clone
     *
     * @param specimenId  (required)
     * @param specimenUpdateFlowerStatus  (required)
     * @return OK (status code 200)
     *         or Error, could not update flowering status (status code 500)
     */
    @Operation(
        operationId = "specimensSpecimenIdFloweringPatch",
        summary = "Update the flowering status of a clone",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecimenUpdateFlowerStatus.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error, could not update flowering status")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/specimens/{specimenId}/flowering",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecimenUpdateFlowerStatus> specimensSpecimenIdFloweringPatch(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId,
        @Parameter(name = "SpecimenUpdateFlowerStatus", description = "", required = true) @Valid @RequestBody SpecimenUpdateFlowerStatus specimenUpdateFlowerStatus
    ) {
        return getDelegate().specimensSpecimenIdFloweringPatch(specimenId, specimenUpdateFlowerStatus);
    }


    /**
     * GET /specimens/{specimenId}
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "specimensSpecimenIdGet",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecimenCloneDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/specimens/{specimenId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<SpecimenCloneDTO> specimensSpecimenIdGet(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId
    ) {
        return getDelegate().specimensSpecimenIdGet(specimenId);
    }


    /**
     * PUT /specimens/{specimenId}/image : update Image
     *
     * @param specimenId  (required)
     * @param file  (optional)
     * @return OK (status code 200)
     *         or Could not update Specimen (status code 500)
     */
    @Operation(
        operationId = "specimensSpecimenIdImagePut",
        summary = "update Image",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Could not update Specimen")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/specimens/{specimenId}/image",
        consumes = { "multipart/form-data" }
    )
    
    default ResponseEntity<Void> specimensSpecimenIdImagePut(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId,
        @Parameter(name = "file", description = "") @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        return getDelegate().specimensSpecimenIdImagePut(specimenId, file);
    }


    /**
     * PATCH /specimens/{specimenId}/sex : Update Sex of a specific Specimen, only works if Specimes current sex is unkown
     *
     * @param specimenId  (required)
     * @param specimenUpdateSex  (required)
     * @return OK (status code 200)
     *         or Error, could not update Specimen Sex (status code 500)
     */
    @Operation(
        operationId = "specimensSpecimenIdSexPatch",
        summary = "Update Sex of a specific Specimen, only works if Specimes current sex is unkown",
        tags = { "Growlistmanagement" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecimenUpdateSex.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error, could not update Specimen Sex")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/specimens/{specimenId}/sex",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecimenUpdateSex> specimensSpecimenIdSexPatch(
        @Parameter(name = "specimenId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("specimenId") String specimenId,
        @Parameter(name = "SpecimenUpdateSex", description = "", required = true) @Valid @RequestBody SpecimenUpdateSex specimenUpdateSex
    ) {
        return getDelegate().specimensSpecimenIdSexPatch(specimenId, specimenUpdateSex);
    }

}
