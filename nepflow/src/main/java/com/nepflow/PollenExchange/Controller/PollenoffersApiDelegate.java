package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.PollenOfferDTO;
import com.nepflow.PollenExchange.Dto.PollenOfferDateContainerDTO;
import com.nepflow.PollenExchange.Dto.PollenOfferSpeciesStatisticsDTO;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link PollenoffersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface PollenoffersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /pollenexchange/pollenoffers/dates : return stored dates (Month-Year)
     *
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenoffersApi#pollenexchangePollenoffersDatesGet
     */
    default ResponseEntity<List<String>> pollenexchangePollenoffersDatesGet() {
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
     * GET /pollenexchange/pollenoffers/open : return open PollenOffers by Month-Year
     *
     * @param dates if dates is not send, the current date in germany will be used (date in Format MM-YYY) (optional)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenoffersApi#pollenexchangePollenoffersOpenGet
     */
    default ResponseEntity<List<PollenOfferDateContainerDTO>> pollenexchangePollenoffersOpenGet(List<String> dates) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"date\" : \"date\", \"pollenOffers\" : [ { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" } ] }, { \"date\" : \"date\", \"pollenOffers\" : [ { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pollenexchange/{username}/pollenoffers/open : return all open PollenOffers of the user
     *
     * @param username  (required)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenoffersApi#pollenexchangeUsernamePollenoffersOpenGet
     */
    default ResponseEntity<List<PollenOfferDTO>> pollenexchangeUsernamePollenoffersOpenGet(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pollenexchange/{username}/pollenoffers/statistics : return PollenOffer statistics on the different specimens
     *
     * @param username  (required)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenoffersApi#pollenexchangeUsernamePollenoffersStatisticsGet
     */
    default ResponseEntity<List<PollenOfferSpeciesStatisticsDTO>> pollenexchangeUsernamePollenoffersStatisticsGet(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"floweringCount\" : 0, \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"cloneId\" : \"cloneId\" }, { \"floweringCount\" : 0, \"specimenId\" : \"specimenId\", \"nepenthesName\" : \"nepenthesName\", \"cloneId\" : \"cloneId\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
