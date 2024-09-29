package com.nepflow.PollenExchange.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nepflow.PollenExchange.Dto.TradeStatus;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TradeRatingDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-29T23:21:38.328386900+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeRatingDTO {

  private String tradeId;

  private String username;

  private String date;

  private TradeStatus status;

  public TradeRatingDTO tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  /**
   * Get tradeId
   * @return tradeId
  */
  
  @Schema(name = "tradeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tradeId")
  public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public TradeRatingDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public TradeRatingDTO date(String date) {
    this.date = date;
    return this;
  }

  /**
   * MM-YYYY
   * @return date
  */
  
  @Schema(name = "date", description = "MM-YYYY", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public TradeRatingDTO status(TradeStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public TradeStatus getStatus() {
    return status;
  }

  public void setStatus(TradeStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeRatingDTO tradeRatingDTO = (TradeRatingDTO) o;
    return Objects.equals(this.tradeId, tradeRatingDTO.tradeId) &&
        Objects.equals(this.username, tradeRatingDTO.username) &&
        Objects.equals(this.date, tradeRatingDTO.date) &&
        Objects.equals(this.status, tradeRatingDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, username, date, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeRatingDTO {\n");
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

