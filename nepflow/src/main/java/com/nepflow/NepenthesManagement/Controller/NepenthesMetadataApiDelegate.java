package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.ProducerDTO;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-19T17:31:01.094750100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface NepenthesMetadataApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /producer : add a new Producer
     *
     * @param producerDTO DTO with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     * @see NepenthesMetadataApi#producerPost
     */
    default ResponseEntity<ProducerDTO> producerPost(ProducerDTO producerDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"contact\" : \"contact\", \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
