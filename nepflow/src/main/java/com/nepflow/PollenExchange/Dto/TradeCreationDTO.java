package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * TradeCreationDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-02T00:12:09.389563100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeCreationDTO {

  private String userInitiated;

  private String userInitiatedOffer;

  private String userRequested;

  private String userRequestedOffer;

  public TradeCreationDTO userInitiated(String userInitiated) {
    this.userInitiated = userInitiated;
    return this;
  }

  /**
   * Get userInitiated
   * @return userInitiated
  */
  
  @Schema(name = "userInitiated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userInitiated")
  public String getUserInitiated() {
    return userInitiated;
  }

  public void setUserInitiated(String userInitiated) {
    this.userInitiated = userInitiated;
  }

  public TradeCreationDTO userInitiatedOffer(String userInitiatedOffer) {
    this.userInitiatedOffer = userInitiatedOffer;
    return this;
  }

  /**
   * Get userInitiatedOffer
   * @return userInitiatedOffer
  */
  
  @Schema(name = "userInitiatedOffer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userInitiatedOffer")
  public String getUserInitiatedOffer() {
    return userInitiatedOffer;
  }

  public void setUserInitiatedOffer(String userInitiatedOffer) {
    this.userInitiatedOffer = userInitiatedOffer;
  }

  public TradeCreationDTO userRequested(String userRequested) {
    this.userRequested = userRequested;
    return this;
  }

  /**
   * Get userRequested
   * @return userRequested
  */
  
  @Schema(name = "userRequested", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userRequested")
  public String getUserRequested() {
    return userRequested;
  }

  public void setUserRequested(String userRequested) {
    this.userRequested = userRequested;
  }

  public TradeCreationDTO userRequestedOffer(String userRequestedOffer) {
    this.userRequestedOffer = userRequestedOffer;
    return this;
  }

  /**
   * Get userRequestedOffer
   * @return userRequestedOffer
  */
  
  @Schema(name = "userRequestedOffer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userRequestedOffer")
  public String getUserRequestedOffer() {
    return userRequestedOffer;
  }

  public void setUserRequestedOffer(String userRequestedOffer) {
    this.userRequestedOffer = userRequestedOffer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeCreationDTO tradeCreationDTO = (TradeCreationDTO) o;
    return Objects.equals(this.userInitiated, tradeCreationDTO.userInitiated) &&
        Objects.equals(this.userInitiatedOffer, tradeCreationDTO.userInitiatedOffer) &&
        Objects.equals(this.userRequested, tradeCreationDTO.userRequested) &&
        Objects.equals(this.userRequestedOffer, tradeCreationDTO.userRequestedOffer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userInitiated, userInitiatedOffer, userRequested, userRequestedOffer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeCreationDTO {\n");
    sb.append("    userInitiated: ").append(toIndentedString(userInitiated)).append("\n");
    sb.append("    userInitiatedOffer: ").append(toIndentedString(userInitiatedOffer)).append("\n");
    sb.append("    userRequested: ").append(toIndentedString(userRequested)).append("\n");
    sb.append("    userRequestedOffer: ").append(toIndentedString(userRequestedOffer)).append("\n");
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

