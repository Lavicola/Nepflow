/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nepflow.NepenthesManagement.Controller;

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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-12T02:26:28.390187200+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Validated
@Tag(name = "NepenthesMetadata", description = "the NepenthesMetadata API")
public interface NepenthesMetadataApi {

    default NepenthesMetadataApiDelegate getDelegate() {
        return new NepenthesMetadataApiDelegate() {};
    }

    /**
     * POST /location : add a new Location
     *
     * @param body LocationdTo with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     */
    @Operation(
        operationId = "locationPost",
        summary = "add a new Location",
        tags = { "NepenthesMetadata" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/location",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> locationPost(
        @Parameter(name = "body", description = "LocationdTo with all necessary Attributes", required = true) @Valid @RequestBody String body
    ) {
        return getDelegate().locationPost(body);
    }


    /**
     * POST /producer : add a new Producer
     *
     * @param body DTO with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     */
    @Operation(
        operationId = "producerPost",
        summary = "add a new Producer",
        tags = { "NepenthesMetadata" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/producer",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> producerPost(
        @Parameter(name = "body", description = "DTO with all necessary Attributes", required = true) @Valid @RequestBody String body
    ) {
        return getDelegate().producerPost(body);
    }

}
