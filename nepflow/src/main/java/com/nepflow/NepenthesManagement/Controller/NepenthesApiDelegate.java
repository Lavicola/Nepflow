package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.*;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link NepenthesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-19T17:31:01.094750100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface NepenthesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/{nepenthesType}/{cloneType}/{name} : get either iv or ic clones of a Nepenthes
     *
     * @param nepenthesType  (required)
     * @param cloneType  (required)
     * @param name  (required)
     * @return OK (status code 200)
     * @see NepenthesApi#cloneNepenthesTypeCloneTypeNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneNepenthesTypeCloneTypeNameGet(NepenthesType nepenthesType,
        CloneType cloneType,
        String name) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clones\" : [ { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" } ], \"label\" : { \"prefix\" : \"prefix\", \"nepenthesName\" : \"nepenthesName\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clone/{nepenthesType}/{cloneType}/{name}/{internalCloneId} : update a Clone
     *
     * @param nepenthesType  (required)
     * @param cloneType  (required)
     * @param name  (required)
     * @param internalCloneId  (required)
     * @return OK (status code 200)
     * @see NepenthesApi#cloneNepenthesTypeCloneTypeNameInternalCloneIdPut
     */
    default ResponseEntity<LabelCloneDTO> cloneNepenthesTypeCloneTypeNameInternalCloneIdPut(NepenthesType nepenthesType,
        CloneType cloneType,
        String name,
        String internalCloneId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clone\" : { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, \"label\" : { \"prefix\" : \"prefix\", \"nepenthesName\" : \"nepenthesName\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/{nepenthesType}/{cloneType}/{name} : add a new clone to a nepenthes
     *
     * @param nepenthesType  (required)
     * @param cloneType  (required)
     * @param name  (required)
     * @param labelCloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see NepenthesApi#cloneNepenthesTypeCloneTypeNamePost
     */
    default ResponseEntity<LabelCloneDTO> cloneNepenthesTypeCloneTypeNamePost(NepenthesType nepenthesType,
        CloneType cloneType,
        String name,
        LabelCloneDTO labelCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clone\" : { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, \"label\" : { \"prefix\" : \"prefix\", \"nepenthesName\" : \"nepenthesName\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clone/{nepenthesType} : get all Nepenthes of a specific Nepenthestype
     *
     * @param nepenthesType  (required)
     * @return OK (status code 200)
     * @see NepenthesApi#cloneNepenthesTypeGet
     */
    default ResponseEntity<List<LabelDTO>> cloneNepenthesTypeGet(NepenthesType nepenthesType) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ \"\", \"\" ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clone/{nepenthesType}/{name} : get all clones of a Nepenthes
     *
     * @param nepenthesType  (required)
     * @param name  (required)
     * @return OK (status code 200)
     * @see NepenthesApi#cloneNepenthesTypeNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneNepenthesTypeNameGet(NepenthesType nepenthesType,
        String name) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clones\" : [ { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" } ], \"label\" : { \"prefix\" : \"prefix\", \"nepenthesName\" : \"nepenthesName\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clones : get all Clones
     *
     * @param cloneIds  (required)
     * @return OK (status code 200)
     * @see NepenthesApi#clonesGet
     */
    default ResponseEntity<List<CloneDTO>> clonesGet(List<String> cloneIds) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
