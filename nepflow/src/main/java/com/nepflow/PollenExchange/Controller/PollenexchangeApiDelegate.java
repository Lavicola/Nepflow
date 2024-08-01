package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.*;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link PollenexchangeApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-02T00:12:09.389563100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
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
                    String exampleString = "{ \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }";
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
     * GET /pollenexchange/pollenoffers : return all PollenOffers of the current Month/Year
     *
     * @param dates enables to show PollenOffers of different dates (MM/YYY) (optional)
     * @return .. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangePollenoffersGet
     */
    default ResponseEntity<List<PollenOfferDateContainerDTO>> pollenexchangePollenoffersGet(List<LocalDate> dates) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"date\" : \"date\", \"pollenOffers\" : [ { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" } ] }, { \"date\" : \"date\", \"pollenOffers\" : [ { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" } ] } ]";
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
                    String exampleString = "{ \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }";
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
     * GET /pollenexchange/trades : return all Trades and their status of the currently logged in user
     *
     * @return User exists. (status code 200)
     *         or error (status code 404)
     * @see PollenexchangeApi#pollenexchangeTradesGet
     */
    default ResponseEntity<List<TradeDateContainerDTO>> pollenexchangeTradesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"date\" : \"date\", \"trades\" : [ { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }, { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" } ] }, { \"date\" : \"date\", \"trades\" : [ { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" }, { \"RequestedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"InitiatedOffer\" : { \"seller\" : \"seller\", \"sex\" : \"sex\", \"nepenthesName\" : \"nepenthesName\", \"location\" : \"location\", \"id\" : \"id\", \"cloneId\" : \"cloneId\", \"user\" : { \"country\" : \"country\", \"username\" : \"username\" }, \"pollenOfferOpenedDate\" : \"2000-01-23\" }, \"tradeOpenedDate\" : \"2000-01-23\", \"id\" : \"id\", \"status\" : \"status\" } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
