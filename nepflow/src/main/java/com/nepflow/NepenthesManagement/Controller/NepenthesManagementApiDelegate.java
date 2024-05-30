package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.HybridCloneDTO;
import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T23:43:49.712163500+02:00[Europe/Berlin]")
public interface NepenthesManagementApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/hybrids/ : get all hybrid Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsGet
     */
    default ResponseEntity<List<HybridCloneDTO>> cloneHybridsGet() {
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
     * GET /clone/hybrids/ic : get all IC Hybrids
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsIcGet
     */
    default ResponseEntity<List<HybridCloneDTO>> cloneHybridsIcGet() {
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
     * POST /clone/hybrids/ic : add a new iv hybrid clone
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsIcPost
     */
    default ResponseEntity<HybridCloneDTO> cloneHybridsIcPost(HybridCloneDTO hybridCloneDTO) {
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
     * PUT /clone/hybrids/ic
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneHybridsIcPut
     */
    default ResponseEntity<HybridCloneDTO> cloneHybridsIcPut(HybridCloneDTO hybridCloneDTO) {
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
     * GET /clone/hybrids/iv : get all IV Hybrids
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsIvGet
     */
    default ResponseEntity<List<HybridCloneDTO>> cloneHybridsIvGet() {
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
     * POST /clone/hybrids/iv : add a new iv hybrid
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneHybridsIvPost
     */
    default ResponseEntity<HybridCloneDTO> cloneHybridsIvPost(HybridCloneDTO hybridCloneDTO) {
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
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneHybridsIvPut
     */
    default ResponseEntity<HybridCloneDTO> cloneHybridsIvPut(HybridCloneDTO hybridCloneDTO) {
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
    default ResponseEntity<List<HybridCloneDTO>> cloneMultiHybridGet() {
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
     * GET /clone/multi-hybrid/ic : get all multi-hybrid IC Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridIcGet
     */
    default ResponseEntity<List<HybridCloneDTO>> cloneMultiHybridIcGet() {
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
     * POST /clone/multi-hybrid/ic : add a new iv multi-hybrid clone
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridIcPost
     */
    default ResponseEntity<HybridCloneDTO> cloneMultiHybridIcPost(HybridCloneDTO hybridCloneDTO) {
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
     * PUT /clone/multi-hybrid/ic
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneMultiHybridIcPut
     */
    default ResponseEntity<HybridCloneDTO> cloneMultiHybridIcPut(HybridCloneDTO hybridCloneDTO) {
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
     * GET /clone/multi-hybrid/iv : get all multi-hybrid IV Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridIvGet
     */
    default ResponseEntity<List<HybridCloneDTO>> cloneMultiHybridIvGet() {
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
     * POST /clone/multi-hybrid/iv : add a new iv multi-hybrid
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneMultiHybridIvPost
     */
    default ResponseEntity<HybridCloneDTO> cloneMultiHybridIvPost(HybridCloneDTO hybridCloneDTO) {
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
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneMultiHybridIvPut
     */
    default ResponseEntity<HybridCloneDTO> cloneMultiHybridIvPut(HybridCloneDTO hybridCloneDTO) {
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
    default ResponseEntity<List<CloneDTO>> cloneSpeciesGet() {
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
     * POST /clone/species/ic : add a new iv clone of a nepenthes
     *
     * @param cloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesIcPost
     */
    default ResponseEntity<CloneDTO> cloneSpeciesIcPost(CloneDTO cloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : \"label\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
     * @param cloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneSpeciesIcPut
     */
    default ResponseEntity<CloneDTO> cloneSpeciesIcPut(CloneDTO cloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : \"label\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
     * @param cloneDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesIvPost
     */
    default ResponseEntity<CloneDTO> cloneSpeciesIvPost(CloneDTO cloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : \"label\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
     * @param cloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#cloneSpeciesIvPut
     */
    default ResponseEntity<CloneDTO> cloneSpeciesIvPut(CloneDTO cloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : \"label\", \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
    default ResponseEntity<CloneDTO> nepenthesNameCloneGet(String name,
        String clone) {
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
    default ResponseEntity<LabelClonesDTO> nepenthesNameGet(String name) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clones\" : [ null, null ], \"label\" : \"label\" }";
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
