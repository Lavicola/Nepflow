package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
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
 * A delegate to be called by the {@link PrimaryHybridApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-11T01:56:15.806697200+02:00[Europe/Berlin]")
public interface PrimaryHybridApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/primary-hybrid/ : get all Primary Hybrids
     *
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridGet
     */
    default ResponseEntity<List<LabelDTO>> clonePrimaryHybridGet() {
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
     * GET /clone/primary-hybrid/ic : get all IC Primary Hybrid Clones
     *
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridIcGet
     */
    default ResponseEntity<List<LabelClonesDTO>> clonePrimaryHybridIcGet() {
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
     * GET /clone/primary-hybrid/ic/{name} : get all IC Clones of a Primary Hybrid
     *
     * @param name  (required)
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridIcNameGet
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridIcNameGet(String name) {
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
     * POST /clone/primary-hybrid/ic/{name} : add a new iv clone to a Primary Hybrid
     *
     * @param name  (required)
     * @param labelClonesDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridIcNamePost
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridIcNamePost(String name,
        LabelClonesDTO labelClonesDTO) {
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
     * PUT /clone/primary-hybrid/ic/{name}
     *
     * @param name  (required)
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see PrimaryHybridApi#clonePrimaryHybridIcNamePut
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridIcNamePut(String name,
        LabelClonesDTO labelClonesDTO) {
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
     * GET /clone/primary-hybrid/iv/{name} : get all Primary Hybrid IV Clones
     *
     * @param name  (required)
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridIvNameGet
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridIvNameGet(String name) {
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
     * POST /clone/primary-hybrid/iv/{name} : add a new iv clone to a Primary Hybrid
     *
     * @param name  (required)
     * @param labelClonesDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridIvNamePost
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridIvNamePost(String name,
        LabelClonesDTO labelClonesDTO) {
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
     * PUT /clone/primary-hybrid/iv/{name}
     *
     * @param name  (required)
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see PrimaryHybridApi#clonePrimaryHybridIvNamePut
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridIvNamePut(String name,
        LabelClonesDTO labelClonesDTO) {
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
     * GET /clone/primary-hybrid/{name} : get all Primary Hybrid Clones of a Primary Hybrid
     *
     * @param name  (required)
     * @return OK (status code 200)
     *         or nepenthes not found (status code 404)
     * @see PrimaryHybridApi#clonePrimaryHybridNameGet
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridNameGet(String name) {
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
     * POST /clone/primary-hybrid/ : add a new Primary Hybrid
     *
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     * @see PrimaryHybridApi#clonePrimaryHybridPost
     */
    default ResponseEntity<LabelClonesDTO> clonePrimaryHybridPost(LabelClonesDTO labelClonesDTO) {
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

}
