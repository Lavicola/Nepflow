package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.*;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link PollenexchangeApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-12T00:59:51.133905700+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface PollenexchangeApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /pollenexchange/create/trade : create a Trade
     *
     * @param tradeCreationDTO  (required)
     * @return Trade created successfully. (status code 200)
     *         or error  e.g userId and OfferId are wrong (status code 404)
     * @see PollenexchangeApi#pollenexchangeCreateTradePost
     */
    default ResponseEntity<TradeDTO> pollenexchangeCreateTradePost(TradeCreationDTO tradeCreationDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pollenexchange/pollenoffers/dates : return stored dates (Month-Year)
     *
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangePollenoffersDatesGet
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
     * @see PollenexchangeApi#pollenexchangePollenoffersOpenGet
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
     * GET /pollenexchange/trade/{tradeId} : get a specific Trade
     *
     * @param tradeId  (required)
     * @return Trade found. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangeTradeTradeIdGet
     */
    default ResponseEntity<TradeDTO> pollenexchangeTradeTradeIdGet(String tradeId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /pollenexchange/trade/{tradeId} : accept or refuse a trade
     *
     * @param tradeId  (required)
     * @param tradeAnswerDTO  (required)
     * @return Trade created successfully. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangeTradeTradeIdPut
     */
    default ResponseEntity<TradeDTO> pollenexchangeTradeTradeIdPut(String tradeId,
        TradeAnswerDTO tradeAnswerDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pollenexchange/trades/dates : return stored dates (Month-Year)
     *
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangeTradesDatesGet
     */
    default ResponseEntity<List<String>> pollenexchangeTradesDatesGet() {
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
     * GET /pollenexchange/{username}/pollenoffers/open : return all open PollenOffers of the user
     *
     * @param username  (required)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangeUsernamePollenoffersOpenGet
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
     * GET /pollenexchange/{username}/trades : return all Trades and their status of the currently logged in user
     *
     * @param username  (required)
     * @param dates if dates is not send, the current date in germany will be used (date in Format MM-YYY) (optional)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangeUsernameTradesGet
     */
    default ResponseEntity<List<TradeDateContainerDTO>> pollenexchangeUsernameTradesGet(String username,
        List<String> dates) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"date\" : \"date\", \"trades\" : [ { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }, { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" } ] }, { \"date\" : \"date\", \"trades\" : [ { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }, { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
