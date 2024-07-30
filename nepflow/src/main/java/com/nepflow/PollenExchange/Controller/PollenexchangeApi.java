/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.PollenOfferDTO;
import com.nepflow.PollenExchange.Dto.TradeAnswerDTO;
import com.nepflow.PollenExchange.Dto.TradeCreationDTO;
import com.nepflow.PollenExchange.Dto.TradeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-31T01:14:44.217476+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
@Validated
@Tag(name = "Pollenexchange", description = "Operations to manage and retrive Users")
public interface PollenexchangeApi {

    default PollenexchangeApiDelegate getDelegate() {
        return new PollenexchangeApiDelegate() {};
    }

    /**
     * POST /pollenexchange/create/trade : create a Trade
     *
     * @param tradeCreationDTO  (required)
     * @return Trade created successfully. (status code 200)
     *         or error  e.g userId and OfferId are wrong (status code 404)
     */
    @Operation(
        operationId = "pollenexchangeCreateTradePost",
        summary = "create a Trade",
        tags = { "Pollenexchange" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Trade created successfully.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TradeDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "error  e.g userId and OfferId are wrong")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pollenexchange/create/trade",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<TradeDTO> pollenexchangeCreateTradePost(
        @Parameter(name = "TradeCreationDTO", description = "", required = true) @Valid @RequestBody TradeCreationDTO tradeCreationDTO
    ) {
        return getDelegate().pollenexchangeCreateTradePost(tradeCreationDTO);
    }


    /**
     * GET /pollenexchange/pollenoffers : return all PollenOffers except the ones of the currently logged in User
     *
     * @return User exists. (status code 200)
     *         or error (status code 404)
     */
    @Operation(
        operationId = "pollenexchangePollenoffersGet",
        summary = "return all PollenOffers except the ones of the currently logged in User",
        tags = { "Pollenexchange" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User exists.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PollenOfferDTO.class)))
            }),
            @ApiResponse(responseCode = "404", description = "error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pollenexchange/pollenoffers",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<PollenOfferDTO>> pollenexchangePollenoffersGet(
        
    ) {
        return getDelegate().pollenexchangePollenoffersGet();
    }


    /**
     * PUT /pollenexchange/trade/{tradeId} : accept or refuse a trade
     *
     * @param tradeId  (required)
     * @param tradeAnswerDTO  (required)
     * @return Trade created successfully. (status code 200)
     *         or error (status code 404)
     */
    @Operation(
        operationId = "pollenexchangeTradeTradeIdPut",
        summary = "accept or refuse a trade",
        tags = { "Pollenexchange" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Trade created successfully.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TradeDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "error")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/pollenexchange/trade/{tradeId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<TradeDTO> pollenexchangeTradeTradeIdPut(
        @Parameter(name = "tradeId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("tradeId") String tradeId,
        @Parameter(name = "TradeAnswerDTO", description = "", required = true) @Valid @RequestBody TradeAnswerDTO tradeAnswerDTO
    ) {
        return getDelegate().pollenexchangeTradeTradeIdPut(tradeId, tradeAnswerDTO);
    }


    /**
     * GET /pollenexchange/trades : return all Trades and their status of the currently logged in user
     *
     * @return User exists. (status code 200)
     *         or error (status code 404)
     */
    @Operation(
        operationId = "pollenexchangeTradesGet",
        summary = "return all Trades and their status of the currently logged in user",
        tags = { "Pollenexchange" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User exists.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TradeDTO.class)))
            }),
            @ApiResponse(responseCode = "404", description = "error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pollenexchange/trades",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<TradeDTO>> pollenexchangeTradesGet(
        
    ) {
        return getDelegate().pollenexchangeTradesGet();
    }

}