package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Dto.CloneType;
import com.nepflow.GrowlistManagement.Dto.GrowlistDTO;
import com.nepflow.GrowlistManagement.Dto.GrowlistPublic;
import com.nepflow.GrowlistManagement.Dto.LabelCloneDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenUpdateFlowerStatus;
import com.nepflow.GrowlistManagement.Dto.SpecimenUpdateSex;
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
 * A delegate to be called by the {@link GrowlistmanagementApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T14:27:09.400598300+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface GrowlistmanagementApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /growlist/clone/add/{internalCloneId} : Add an existing Clone of a Nepenthes to the Growlist.
     *
     * @param internalCloneId  (required)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     * @see GrowlistmanagementApi#growlistCloneAddInternalCloneIdPost
     */
    default ResponseEntity<SpecimenCloneDTO> growlistCloneAddInternalCloneIdPost(String internalCloneId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /growlist/create/clone/{cloneType} : Create a new IV or IC Clone and Add it to the Growlist
     *
     * @param cloneType  (required)
     * @param labelCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     * @see GrowlistmanagementApi#growlistCreateCloneCloneTypePost
     */
    default ResponseEntity<SpecimenCloneDTO> growlistCreateCloneCloneTypePost(CloneType cloneType,
        LabelCloneDTO labelCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /growlist/create/nepenthes/{cloneType} : Create a new Nepenthes and an additional IV or IC Clone and Add it to the Growlist
     *
     * @param cloneType  (required)
     * @param labelCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     * @see GrowlistmanagementApi#growlistCreateNepenthesCloneTypePost
     */
    default ResponseEntity<SpecimenCloneDTO> growlistCreateNepenthesCloneTypePost(CloneType cloneType,
        LabelCloneDTO labelCloneDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /growlist/{growlistId}/public : set Growlist to public or private
     *
     * @param growlistId  (required)
     * @param growlistPublic  (required)
     * @return OK (status code 200)
     * @see GrowlistmanagementApi#growlistGrowlistIdPublicPatch
     */
    default ResponseEntity<GrowlistPublic> growlistGrowlistIdPublicPatch(String growlistId,
        GrowlistPublic growlistPublic) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"isPublic\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /growlist/{username}/clones : get all Specimens of a specific User, if Growlist is public
     *
     * @param username  (required)
     * @return OK (status code 200)
     *         or Error, User not found (status code 404)
     * @see GrowlistmanagementApi#growlistUsernameClonesGet
     */
    default ResponseEntity<GrowlistDTO> growlistUsernameClonesGet(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"isPublic\" : true, \"specimens\" : [ { \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, { \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" } ], \"id\" : \"id\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /specimens/{specimenId} : remove a specimen from the growlistist. If the removed plant was already used for a trade, only a soft delete will happen
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     *         or Error, could not add Nepenthes Clone to user (status code 500)
     * @see GrowlistmanagementApi#specimensSpecimenIdDelete
     */
    default ResponseEntity<Void> specimensSpecimenIdDelete(String specimenId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /specimens/{specimenId}/flowering : Update the flowering status of a clone
     *
     * @param specimenId  (required)
     * @param specimenUpdateFlowerStatus  (required)
     * @return OK (status code 200)
     *         or Error, could not update flowering status (status code 500)
     * @see GrowlistmanagementApi#specimensSpecimenIdFloweringPatch
     */
    default ResponseEntity<SpecimenUpdateFlowerStatus> specimensSpecimenIdFloweringPatch(String specimenId,
        SpecimenUpdateFlowerStatus specimenUpdateFlowerStatus) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"isFlowering\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /specimens/{specimenId}
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     * @see GrowlistmanagementApi#specimensSpecimenIdGet
     */
    default ResponseEntity<SpecimenCloneDTO> specimensSpecimenIdGet(String specimenId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /specimens/{specimenId}/image : update Image
     *
     * @param specimenId  (required)
     * @param file  (optional)
     * @return OK (status code 200)
     *         or Could not update Specimen (status code 500)
     * @see GrowlistmanagementApi#specimensSpecimenIdImagePut
     */
    default ResponseEntity<Void> specimensSpecimenIdImagePut(String specimenId,
        MultipartFile file) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /specimens/{specimenId}/sex : Update Sex of a specific Specimen, only works if Specimes current sex is unkown
     *
     * @param specimenId  (required)
     * @param specimenUpdateSex  (required)
     * @return OK (status code 200)
     *         or Error, could not update Specimen Sex (status code 500)
     * @see GrowlistmanagementApi#specimensSpecimenIdSexPatch
     */
    default ResponseEntity<SpecimenUpdateSex> specimensSpecimenIdSexPatch(String specimenId,
        SpecimenUpdateSex specimenUpdateSex) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sex\" : \"sex\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
