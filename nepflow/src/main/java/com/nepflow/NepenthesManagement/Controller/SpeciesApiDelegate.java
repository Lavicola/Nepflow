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
 * A delegate to be called by the {@link SpeciesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-11T01:56:15.806697200+02:00[Europe/Berlin]")
public interface SpeciesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clone/species/ : get all Species
     *
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesGet
     */
    default ResponseEntity<List<LabelDTO>> cloneSpeciesGet() {
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
     * GET /clone/species/ic : get all IC Species Clones
     *
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesIcGet
     */
    default ResponseEntity<List<LabelClonesDTO>> cloneSpeciesIcGet() {
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
     * GET /clone/species/ic/{name} : get all IC Species Clones of a Nepenthes
     *
     * @param name  (required)
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesIcNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesIcNameGet(String name) {
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
     * POST /clone/species/ic/{name} : add a new iv clone to a nepenthes
     *
     * @param name  (required)
     * @param labelClonesDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesIcNamePost
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesIcNamePost(String name,
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
     * PUT /clone/species/ic/{name}
     *
     * @param name  (required)
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see SpeciesApi#cloneSpeciesIcNamePut
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesIcNamePut(String name,
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
     * GET /clone/species/iv/{name} : get all IC Species Clones of a Nepenthes
     *
     * @param name  (required)
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesIvNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesIvNameGet(String name) {
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
     * POST /clone/species/iv/{name} : add a new iv clone to a nepenthes
     *
     * @param name  (required)
     * @param labelClonesDTO Clone DTO with new values (required)
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesIvNamePost
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesIvNamePost(String name,
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
     * PUT /clone/species/iv/{name}
     *
     * @param name  (required)
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     *         or No nepenthes found (status code 404)
     * @see SpeciesApi#cloneSpeciesIvNamePut
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesIvNamePut(String name,
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
     * GET /clone/species/{name} : get a Species and their clones
     *
     * @param name  (required)
     * @return OK (status code 200)
     *         or nepenthes not found (status code 404)
     * @see SpeciesApi#cloneSpeciesNameGet
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesNameGet(String name) {
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
     * POST /clone/species/ : add a new Species
     *
     * @param labelClonesDTO  (required)
     * @return OK (status code 200)
     * @see SpeciesApi#cloneSpeciesPost
     */
    default ResponseEntity<LabelClonesDTO> cloneSpeciesPost(LabelClonesDTO labelClonesDTO) {
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
