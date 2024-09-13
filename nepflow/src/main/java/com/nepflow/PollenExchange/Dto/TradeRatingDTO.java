package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nepflow.PollenExchange.Model.TradeRating.RATING;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * TradeRatingDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T22:16:38.894889700+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeRatingDTO {

  private String tradeId;

  private String date;

  private RATING status;

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

  public TradeRatingDTO status(RATING status) {
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
  public RATING getStatus() {
    return status;
  }

  public void setStatus(RATING status) {
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
        Objects.equals(this.date, tradeRatingDTO.date) &&
        Objects.equals(this.status, tradeRatingDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, date, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeRatingDTO {\n");
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
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

