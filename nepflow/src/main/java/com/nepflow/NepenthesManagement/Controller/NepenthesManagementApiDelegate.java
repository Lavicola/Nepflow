package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.ICCloneDTO;
import com.nepflow.NepenthesManagement.Dto.IVCloneDTO;
import com.nepflow.NepenthesManagement.Dto.NepenthesClonesDTO;
import com.nepflow.NepenthesManagement.Dto.NepenthesNameCloneGet200Response;
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
 * A delegate to be called by the {@link NepenthesManagementApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-11T01:52:33.806154159+02:00[Europe/Berlin]")
public interface NepenthesManagementApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/hybrid : get all hybrids
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridGet
     */
    default ResponseEntity<List<CloneDTO>> cloneHybridGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"clonId\" : \"clonId\", \"sex\" : \"sex\", \"name\" : \"name\" }, { \"clonId\" : \"clonId\", \"sex\" : \"sex\", \"name\" : \"name\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/hybrid : add a new hybrid
     *
     * @param cloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridPost
     */
    default ResponseEntity<CloneDTO> cloneHybridPost(CloneDTO cloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clonId\" : \"clonId\", \"sex\" : \"sex\", \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/ic : add a new ic clone of a nepenthes
     *
     * @param icCloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneIcPost
     */
    default ResponseEntity<ICCloneDTO> cloneIcPost(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"mountain\" : \"mountain\", \"clonId\" : \"clonId\", \"sex\" : \"sex\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clone/ic : add/edit information of an existing clone (only sex allowed)
     *
     * @param icCloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneIcPut
     */
    default ResponseEntity<ICCloneDTO> cloneIcPut(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"mountain\" : \"mountain\", \"clonId\" : \"clonId\", \"sex\" : \"sex\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/iv : add a new iv clone of a nepenthes
     *
     * @param ivCloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneIvPost
     */
    default ResponseEntity<IVCloneDTO> cloneIvPost(IVCloneDTO ivCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clone/iv : add/edit information of an existing clone (only sex allowed)
     *
     * @param ivCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneIvPut
     */
    default ResponseEntity<IVCloneDTO> cloneIvPut(IVCloneDTO ivCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clone/multihybrid : get all multihybrids
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultihybridGet
     */
    default ResponseEntity<List<CloneDTO>> cloneMultihybridGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"clonId\" : \"clonId\", \"sex\" : \"sex\", \"name\" : \"name\" }, { \"clonId\" : \"clonId\", \"sex\" : \"sex\", \"name\" : \"name\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/multihybrid : add a new multihybrid
     *
     * @param cloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultihybridPost
     */
    default ResponseEntity<CloneDTO> cloneMultihybridPost(CloneDTO cloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clonId\" : \"clonId\", \"sex\" : \"sex\", \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /mountain : add a new Mountain
     *
     * @param body MountainDTO with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     * @see NepenthesManagementApi#mountainPost
     */
    default ResponseEntity<String> mountainPost(String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /nepenthes : get all nepenthes
     *
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#nepenthesGet
     */
    default ResponseEntity<List<String>> nepenthesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ null, null ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /nepenthes/{name}/{clone} : get s specific clone
     *
     * @param name  (required)
     * @param clone  (required)
     * @return OK (status code 200)
     *         or Clone does not exist (status code 404)
     * @see NepenthesManagementApi#nepenthesNameCloneGet
     */
    default ResponseEntity<NepenthesNameCloneGet200Response> nepenthesNameCloneGet(String name,
        String clone) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /nepenthes/{name} : get a nepenthes and their clones
     *
     * @param name  (required)
     * @return OK (status code 200)
     *         or nepenthes not found (status code 404)
     * @see NepenthesManagementApi#nepenthesNameGet
     */
    default ResponseEntity<NepenthesClonesDTO> nepenthesNameGet(String name) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"clones\" : [ null, null ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /nepenthes : Create new nepenthes
     *
     * @param body  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#nepenthesPost
     */
    default ResponseEntity<String> nepenthesPost(String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /producer : add a new Producer
     *
     * @param body DTO with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     * @see NepenthesManagementApi#producerPost
     */
    default ResponseEntity<String> producerPost(String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
