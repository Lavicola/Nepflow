package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Dto.*;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**
 * A delegate to be called by the {@link GrowlistmanagementApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-13T22:57:38.084130600+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
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
     * POST /growlist/clone/create/{cloneType} : Create a new IV or IC Clone and Add it to the Growlist
     *
     * @param cloneType  (required)
     * @param labelCloneDTO  (optional)
     * @return OK (status code 200)
     *         or Error, could not add Specimen to user (status code 500)
     * @see GrowlistmanagementApi#growlistCloneCreateCloneTypePost
     */
    default ResponseEntity<SpecimenCloneDTO> growlistCloneCreateCloneTypePost(CloneType cloneType,
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
     * DELETE /growlist/clones/{specimenId} : remove a clone from the growlisti If the removed plant was already used for a trade it will be a soft delete in the relation part
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     *         or Error, could not add Nepenthes Clone to user (status code 500)
     * @see GrowlistmanagementApi#growlistClonesSpecimenIdDelete
     */
    default ResponseEntity<Void> growlistClonesSpecimenIdDelete(String specimenId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /growlist/clones/{specimenId}/flowering : Update the flowering status of a clone
     *
     * @param specimenId  (required)
     * @param specimenUpdateFlowerStatus  (required)
     * @return OK (status code 200)
     *         or Error, could not update flowering status (status code 500)
     * @see GrowlistmanagementApi#growlistClonesSpecimenIdFloweringPatch
     */
    default ResponseEntity<SpecimenUpdateFlowerStatus> growlistClonesSpecimenIdFloweringPatch(String specimenId,
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
     * GET /growlist/clones/{specimenId}
     *
     * @param specimenId  (required)
     * @return OK (status code 200)
     * @see GrowlistmanagementApi#growlistClonesSpecimenIdGet
     */
    default ResponseEntity<SpecimenCloneDTO> growlistClonesSpecimenIdGet(String specimenId) {
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
     * PUT /growlist/clones/{specimenId} : update values
     *
     * @param specimenId  (required)
     * @param sex  (optional)
     * @param file  (optional)
     * @return OK (status code 200)
     *         or Could not update Specimen (status code 500)
     * @see GrowlistmanagementApi#growlistClonesSpecimenIdPut
     */
    default ResponseEntity<Void> growlistClonesSpecimenIdPut(String specimenId,
        String sex,
        MultipartFile file) {
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
                    String exampleString = "{ \"specimens\" : [ { \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, { \"filelocation\" : \"filelocation\", \"isFlowering\" : true, \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" } ], \"id\" : \"id\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
