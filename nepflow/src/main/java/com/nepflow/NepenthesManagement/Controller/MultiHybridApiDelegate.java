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
 * A delegate to be called by the {@link MultiHybridApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-11T01:56:15.806697200+02:00[Europe/Berlin]")
public interface MultiHybridApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/multi-hybrid/ : get all Multi Hybrids
     *
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridGet
     */
    default ResponseEntity<List<LabelDTO>> cloneMultiHybridGet() {
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
     * GET /clone/multi-hybrid/ic : get all IC Multi Hybrid Clones
     *
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridIcGet
     */
    default ResponseEntity<List<LabelClonesDTO>> cloneMultiHybridIcGet() {
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
     * GET /clone/multi-hybrid/ic/{name} : get all IC Clones of a Multi Hybrid
     *
     * @param name  (required)
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridIcNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridIcNameGet(String name) {
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
     * POST /clone/multi-hybrid/ic/{name} : add a new iv clone to a Multi Hybrid
     *
     * @param name  (required)
     * @param labelClonesDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridIcNamePost
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridIcNamePost(String name,
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
     * PUT /clone/multi-hybrid/ic/{name}
     *
     * @param name  (required)
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see MultiHybridApi#cloneMultiHybridIcNamePut
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridIcNamePut(String name,
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
     * GET /clone/multi-hybrid/iv/{name} : get all Multi Hybrid IV Clones
     *
     * @param name  (required)
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridIvNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridIvNameGet(String name) {
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
     * POST /clone/multi-hybrid/iv/{name} : add a new iv clone to a Multi Hybrid
     *
     * @param name  (required)
     * @param labelClonesDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridIvNamePost
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridIvNamePost(String name,
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
     * PUT /clone/multi-hybrid/iv/{name}
     *
     * @param name  (required)
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see MultiHybridApi#cloneMultiHybridIvNamePut
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridIvNamePut(String name,
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
     * GET /clone/multi-hybrid/{name} : get all Multi Hybrid Clones of a Multi Hybrid
     *
     * @param name  (required)
     * @return OK (status code 200)
     *         or nepenthes not found (status code 404)
     * @see MultiHybridApi#cloneMultiHybridNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridNameGet(String name) {
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
     * POST /clone/multi-hybrid/ : add a new Multi Hybrids
     *
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     * @see MultiHybridApi#cloneMultiHybridPost
     */
    default ResponseEntity<LabelClonesDTO> cloneMultiHybridPost(LabelClonesDTO labelClonesDTO) {
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
