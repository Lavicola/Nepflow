package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Dto.CloneType;
import com.nepflow.GrowlistManagement.Dto.GrowlistDTO;
import com.nepflow.GrowlistManagement.Dto.LabelCloneDTO;
import com.nepflow.GrowlistManagement.Dto.LabelSpecimenDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-26T22:21:12.014973900+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
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
                    String exampleString = "{ \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }";
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
                    String exampleString = "{ \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }";
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
     * PUT /growlist/clones/{specimenId} : update values
     *
     * @param specimenId  (required)
     * @param labelSpecimenDTO  (optional)
     * @return OK (status code 200)
     *         or Could not update Specimen (status code 500)
     * @see GrowlistmanagementApi#growlistClonesSpecimenIdPut
     */
    default ResponseEntity<LabelSpecimenDTO> growlistClonesSpecimenIdPut(String specimenId,
        LabelSpecimenDTO labelSpecimenDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clone\" : { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /growlist/{username}/clones : get Nepenthes of a specific User
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
                    String exampleString = "{ \"specimens\" : [ { \"clone\" : { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" } }, { \"clone\" : { \"sex\" : \"sex\", \"nickname\" : \"nickname\", \"description\" : \"description\", \"producer\" : \"producer\", \"specimenId\" : \"specimenId\", \"internalCloneId\" : \"internalCloneId\", \"cloneId\" : \"cloneId\", \"Location\" : \"Location\" }, \"label\" : { \"prefix\" : \"prefix\", \"name\" : \"name\" } } ], \"id\" : \"id\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
