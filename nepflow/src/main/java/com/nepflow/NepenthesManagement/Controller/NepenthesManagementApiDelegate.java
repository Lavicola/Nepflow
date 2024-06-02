package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.HybridCloneDTO;
import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link NepenthesManagementApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T22:42:44.669728600+02:00[Europe/Berlin]")
public interface NepenthesManagementApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
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
     * GET /clone/primary-hybrids/ : get all hybrid Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#clonePrimaryHybridsGet
     */
    default ResponseEntity<List<HybridCloneDTO>> clonePrimaryHybridsGet() {
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
     * GET /clone/primary-hybrids/ic : get all IC Hybrids
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#clonePrimaryHybridsIcGet
     */
    default ResponseEntity<List<HybridCloneDTO>> clonePrimaryHybridsIcGet() {
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
     * POST /clone/primary-hybrids/ic : add a new iv hybrid clone
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#clonePrimaryHybridsIcPost
     */
    default ResponseEntity<HybridCloneDTO> clonePrimaryHybridsIcPost(HybridCloneDTO hybridCloneDTO) {
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
     * PUT /clone/primary-hybrids/ic
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#clonePrimaryHybridsIcPut
     */
    default ResponseEntity<HybridCloneDTO> clonePrimaryHybridsIcPut(HybridCloneDTO hybridCloneDTO) {
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
     * GET /clone/primary-hybrids/iv : get all IV Hybrids
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#clonePrimaryHybridsIvGet
     */
    default ResponseEntity<List<HybridCloneDTO>> clonePrimaryHybridsIvGet() {
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
     * POST /clone/primary-hybrids/iv : add a new iv hybrid
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     * @see NepenthesManagementApi#clonePrimaryHybridsIvPost
     */
    default ResponseEntity<HybridCloneDTO> clonePrimaryHybridsIvPost(HybridCloneDTO hybridCloneDTO) {
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
     * PUT /clone/primary-hybrids/iv
     *
     * @param hybridCloneDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#clonePrimaryHybridsIvPut
     */
    default ResponseEntity<HybridCloneDTO> clonePrimaryHybridsIvPut(HybridCloneDTO hybridCloneDTO) {
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
     * GET /clone/species/ic : get all IV Species Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesIcGet
     */
    default ResponseEntity<List<CloneDTO>> cloneSpeciesIcGet() {
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
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" }, \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" }, \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clone/species/iv : get all IV Species Clones
     *
     * @return OK (status code 200)
     * @see NepenthesManagementApi#cloneSpeciesIvGet
     */
    default ResponseEntity<List<CloneDTO>> cloneSpeciesIvGet() {
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
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" }, \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
                    String exampleString = "{ \"InternalcloneId\" : \"InternalcloneId\", \"sex\" : \"sex\", \"producer\" : \"producer\", \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" }, \"cloneId\" : \"cloneId\", \"grex\" : { \"cloneId\" : \"cloneId\" }, \"Location\" : \"Location\" }";
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
    default ResponseEntity<List<LabelDTO>> nepenthesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"prefix\" : \"prefix\", \"name\" : \"name\" }, { \"prefix\" : \"prefix\", \"name\" : \"name\" } ]";
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
                    String exampleString = "{ \"clones\" : [ null, null ], \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" } }";
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
     * @param labelDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see NepenthesManagementApi#nepenthesPost
     */
    default ResponseEntity<LabelDTO> nepenthesPost(LabelDTO labelDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"prefix\" : \"prefix\", \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
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
