package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneHybridsGet200ResponseInner;
import com.nepflow.NepenthesManagement.Dto.CloneSpeciesGet200ResponseInner;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T00:38:12.962208100+02:00[Europe/Berlin]")
public interface NepenthesManagementApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/hybrids/ : get all Species Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsGet
     */
    default ResponseEntity<List<CloneHybridsGet200ResponseInner>> cloneHybridsGet() {
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
     * POST /clone/hybrids/ic : add a new iv hybrid clone
     *
     * @param icCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsIcPost
     */
    default ResponseEntity<ICCloneDTO> cloneHybridsIcPost(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"sex\" : \"sex\", \"name\" : \"name\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clone/hybrids/ic
     *
     * @param icCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneHybridsIcPut
     */
    default ResponseEntity<ICCloneDTO> cloneHybridsIcPut(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"sex\" : \"sex\", \"name\" : \"name\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/hybrids/iv : add a new iv hybrid
     *
     * @param ivCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsIvPost
     */
    default ResponseEntity<IVCloneDTO> cloneHybridsIvPost(IVCloneDTO ivCloneDTO) {
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
     * PUT /clone/hybrids/iv
     *
     * @param ivCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneHybridsIvPut
     */
    default ResponseEntity<IVCloneDTO> cloneHybridsIvPut(IVCloneDTO ivCloneDTO) {
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
     * GET /clone/multi-hybrid/ : get all multi-hybrid Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridGet
     */
    default ResponseEntity<List<CloneHybridsGet200ResponseInner>> cloneMultiHybridGet() {
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
     * POST /clone/multi-hybrid/ic : add a new iv multi-hybrid clone
     *
     * @param icCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridIcPost
     */
    default ResponseEntity<ICCloneDTO> cloneMultiHybridIcPost(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"sex\" : \"sex\", \"name\" : \"name\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clone/multi-hybrid/ic
     *
     * @param icCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneMultiHybridIcPut
     */
    default ResponseEntity<ICCloneDTO> cloneMultiHybridIcPut(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"sex\" : \"sex\", \"name\" : \"name\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/multi-hybrid/iv : add a new iv multi-hybrid
     *
     * @param ivCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridIvPost
     */
    default ResponseEntity<IVCloneDTO> cloneMultiHybridIvPost(IVCloneDTO ivCloneDTO) {
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
     * PUT /clone/multi-hybrid/iv
     *
     * @param ivCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneMultiHybridIvPut
     */
    default ResponseEntity<IVCloneDTO> cloneMultiHybridIvPut(IVCloneDTO ivCloneDTO) {
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
     * GET /clone/species/ : get all Species Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesGet
     */
    default ResponseEntity<List<CloneSpeciesGet200ResponseInner>> cloneSpeciesGet() {
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
     * POST /clone/species/ic : add a new iv clone of a nepenthes
     *
     * @param icCloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesIcPost
     */
    default ResponseEntity<ICCloneDTO> cloneSpeciesIcPost(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"sex\" : \"sex\", \"name\" : \"name\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clone/species/ic
     *
     * @param icCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneSpeciesIcPut
     */
    default ResponseEntity<ICCloneDTO> cloneSpeciesIcPut(ICCloneDTO icCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nepenthes\" : \"nepenthes\", \"sex\" : \"sex\", \"name\" : \"name\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clone/species/iv : add a new iv clone of a nepenthes
     *
     * @param ivCloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesIvPost
     */
    default ResponseEntity<IVCloneDTO> cloneSpeciesIvPost(IVCloneDTO ivCloneDTO) {
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
     * PUT /clone/species/iv
     *
     * @param ivCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneSpeciesIvPut
     */
    default ResponseEntity<IVCloneDTO> cloneSpeciesIvPut(IVCloneDTO ivCloneDTO) {
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
     * POST /location : add a new Location
     *
     * @param body LocationdTo with all necessary Attributes (required)
     * @return OK (status code 200)
     *         or Internal Error (status code 500)
     * @see NepenthesManagementApi#locationPost
     */
    default ResponseEntity<String> locationPost(String body) {
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
