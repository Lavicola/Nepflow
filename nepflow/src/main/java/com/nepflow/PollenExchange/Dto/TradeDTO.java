package com.nepflow.PollenExchange.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.PollenExchange.Dto.PollenOfferDTO;
import com.nepflow.PollenExchange.Dto.TradeRatingDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TradeDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-29T23:21:38.328386900+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeDTO {

  private String id;

  private String status;

  private PollenOfferDTO initiatedOffer;

  private PollenOfferDTO requestedOffer;

  @Valid
  private List<@Valid TradeRatingDTO> tradeRatingsDTO = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate tradeOpenedDate;

  public TradeDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TradeDTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public TradeDTO initiatedOffer(PollenOfferDTO initiatedOffer) {
    this.initiatedOffer = initiatedOffer;
    return this;
  }

  /**
   * Get initiatedOffer
   * @return initiatedOffer
  */
  @Valid 
  @Schema(name = "InitiatedOffer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("InitiatedOffer")
  public PollenOfferDTO getInitiatedOffer() {
    return initiatedOffer;
  }

  public void setInitiatedOffer(PollenOfferDTO initiatedOffer) {
    this.initiatedOffer = initiatedOffer;
  }

  public TradeDTO requestedOffer(PollenOfferDTO requestedOffer) {
    this.requestedOffer = requestedOffer;
    return this;
  }

  /**
   * Get requestedOffer
   * @return requestedOffer
  */
  @Valid 
  @Schema(name = "RequestedOffer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("RequestedOffer")
  public PollenOfferDTO getRequestedOffer() {
    return requestedOffer;
  }

  public void setRequestedOffer(PollenOfferDTO requestedOffer) {
    this.requestedOffer = requestedOffer;
  }

  public TradeDTO tradeRatingsDTO(List<@Valid TradeRatingDTO> tradeRatingsDTO) {
    this.tradeRatingsDTO = tradeRatingsDTO;
    return this;
  }

  public TradeDTO addTradeRatingsDTOItem(TradeRatingDTO tradeRatingsDTOItem) {
    if (this.tradeRatingsDTO == null) {
      this.tradeRatingsDTO = new ArrayList<>();
    }
    this.tradeRatingsDTO.add(tradeRatingsDTOItem);
    return this;
  }

  /**
   * Get tradeRatingsDTO
   * @return tradeRatingsDTO
  */
  @Valid 
  @Schema(name = "TradeRatingsDTO", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("TradeRatingsDTO")
  public List<@Valid TradeRatingDTO> getTradeRatingsDTO() {
    return tradeRatingsDTO;
  }

  public void setTradeRatingsDTO(List<@Valid TradeRatingDTO> tradeRatingsDTO) {
    this.tradeRatingsDTO = tradeRatingsDTO;
  }

  public TradeDTO tradeOpenedDate(LocalDate tradeOpenedDate) {
    this.tradeOpenedDate = tradeOpenedDate;
    return this;
  }

  /**
   * Get tradeOpenedDate
   * @return tradeOpenedDate
  */
  @Valid 
  @Schema(name = "tradeOpenedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tradeOpenedDate")
  public LocalDate getTradeOpenedDate() {
    return tradeOpenedDate;
  }

  public void setTradeOpenedDate(LocalDate tradeOpenedDate) {
    this.tradeOpenedDate = tradeOpenedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeDTO tradeDTO = (TradeDTO) o;
    return Objects.equals(this.id, tradeDTO.id) &&
        Objects.equals(this.status, tradeDTO.status) &&
        Objects.equals(this.initiatedOffer, tradeDTO.initiatedOffer) &&
        Objects.equals(this.requestedOffer, tradeDTO.requestedOffer) &&
        Objects.equals(this.tradeRatingsDTO, tradeDTO.tradeRatingsDTO) &&
        Objects.equals(this.tradeOpenedDate, tradeDTO.tradeOpenedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, initiatedOffer, requestedOffer, tradeRatingsDTO, tradeOpenedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    initiatedOffer: ").append(toIndentedString(initiatedOffer)).append("\n");
    sb.append("    requestedOffer: ").append(toIndentedString(requestedOffer)).append("\n");
    sb.append("    tradeRatingsDTO: ").append(toIndentedString(tradeRatingsDTO)).append("\n");
    sb.append("    tradeOpenedDate: ").append(toIndentedString(tradeOpenedDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

