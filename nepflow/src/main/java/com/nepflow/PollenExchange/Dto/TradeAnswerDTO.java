package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * TradeAnswerDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T22:16:38.894889700+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeAnswerDTO {

  private Boolean acceptTrade;

  public TradeAnswerDTO acceptTrade(Boolean acceptTrade) {
    this.acceptTrade = acceptTrade;
    return this;
  }

  /**
   * Get acceptTrade
   * @return acceptTrade
  */
  
  @Schema(name = "acceptTrade", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("acceptTrade")
  public Boolean getAcceptTrade() {
    return acceptTrade;
  }

  public void setAcceptTrade(Boolean acceptTrade) {
    this.acceptTrade = acceptTrade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeAnswerDTO tradeAnswerDTO = (TradeAnswerDTO) o;
    return Objects.equals(this.acceptTrade, tradeAnswerDTO.acceptTrade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptTrade);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeAnswerDTO {\n");
    sb.append("    acceptTrade: ").append(toIndentedString(acceptTrade)).append("\n");
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

