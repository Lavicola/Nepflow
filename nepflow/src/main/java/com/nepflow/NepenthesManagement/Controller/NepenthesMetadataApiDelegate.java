package com.nepflow.NepenthesManagement.Controller;

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
 * A delegate to be called by the {@link NepenthesMetadataApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-20T00:23:06.948612500+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface NepenthesMetadataApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /location : add a new Location
     *
     * @param body LocationdTo with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     * @see NepenthesMetadataApi#locationPost
     */
    default ResponseEntity<String> locationPost(String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /producer : add a new Producer
     *
     * @param body DTO with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     * @see NepenthesMetadataApi#producerPost
     */
    default ResponseEntity<String> producerPost(String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
