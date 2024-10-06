package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.*;
import jakarta.annotation.Generated;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link TradesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface TradesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /pollenexchange/create/trade : create a Trade
     *
     * @param tradeCreationDTO  (required)
     * @return Trade created successfully. (status code 200)
     *         or error  e.g userId and OfferId are wrong (status code 404)
     * @see TradesApi#pollenexchangeCreateTradePost
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
     * GET /pollenexchange/trade/{tradeId} : get a specific Trade
     *
     * @param tradeId  (required)
     * @return Trade found. (status code 200)
     *         or error (status code 404)
     * @see TradesApi#pollenexchangeTradeTradeIdGet
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
     * @see TradesApi#pollenexchangeTradeTradeIdPut
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
     * GET /pollenexchange/trades/dates : return stored dates (Month-Year) the current logged in user has trades
     *
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see TradesApi#pollenexchangeTradesDatesGet
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
     * GET /pollenexchange/trades : return all Trades and their status of the currently logged in user
     *
     * @param dates if dates is not send, the current date in germany will be used (date in Format MM-YYY) (optional)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see TradesApi#pollenexchangeTradesGet
     */
    default ResponseEntity<List<TradeDateContainerDTO>> pollenexchangeTradesGet(List<String> dates) {
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

    /**
     * GET /pollenexchange/trades/rateable : return all rateable trades of the currently logged in user
     *
     * @return return all trades which are still rateable (status code 200)
     *         or error (status code 404)
     * @see TradesApi#pollenexchangeTradesRateableGet
     */
    default ResponseEntity<List<TradeDTO>> pollenexchangeTradesRateableGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }, { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\", \"imageLocation\" : \"imageLocation\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pollenexchange/{username}/trades/status : return the status of all Trades from the Viewpoint of the User
     *
     * @param username  (required)
     * @return status of all Trades from the Viewpoint of the User (status code 200)
     *         or error (status code 404)
     * @see TradesApi#pollenexchangeUsernameTradesStatusGet
     */
    default ResponseEntity<List<TradeStatusDTO>> pollenexchangeUsernameTradesStatusGet(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"creationDate\" : \"2000-01-23\", \"tradeId\" : \"tradeId\", \"status\" : \"SUCCESS\" }, { \"creationDate\" : \"2000-01-23\", \"tradeId\" : \"tradeId\", \"status\" : \"SUCCESS\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /trades/{tradeId}/rating : leave feedback/rate a specific Trade
     *
     * @param tradeId  (required)
     * @param comment  (optional)
     * @param file  (optional)
     * @param reviewType  (optional)
     * @return feedback for the Trade was saved. (status code 200)
     *         or error (status code 404)
     * @see TradesApi#tradesTradeIdRatingPost
     */
    default ResponseEntity<NewRatingResponseDTO> tradesTradeIdRatingPost(String tradeId,
        String comment,
        MultipartFile file,
        com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"reviewType\" : \"SUCCESS\", \"comment\" : \"comment\", \"imageLocation\" : \"imageLocation\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /trades/{username}/ratings : get received ratings of a specific User
     *
     * @param username  (required)
     * @param pageable  (optional)
     * @return received Ratings of a user. (status code 200)
     *         or error (status code 404)
     * @see TradesApi#tradesUsernameRatingsGet
     */
    default ResponseEntity<RatingPage> tradesUsernameRatingsGet(String username,
        Pageable pageable) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pageNumber\" : 6, \"ratings\" : [ { \"file\" : \"\", \"rater\" : \"rater\", \"receivedOn\" : \"receivedOn\", \"reviewType\" : \"SUCCESS\", \"comment\" : \"comment\", \"tradeId\" : \"tradeId\" }, { \"file\" : \"\", \"rater\" : \"rater\", \"receivedOn\" : \"receivedOn\", \"reviewType\" : \"SUCCESS\", \"comment\" : \"comment\", \"tradeId\" : \"tradeId\" } ], \"totalPages\" : 1, \"pageSize\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
