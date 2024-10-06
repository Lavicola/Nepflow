package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * the Status of a Trade from a viewpoint of a specific User
 */

@Schema(name = "TradeStatusDTO", description = "the Status of a Trade from a viewpoint of a specific User")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeStatusDTO {

  private String tradeId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate creationDate;

  private com.nepflow.PollenExchange.Model.TradeRating.RATING status;

  public TradeStatusDTO tradeId(String tradeId) {
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

  public TradeStatusDTO creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * the date the trade was accepted
   * @return creationDate
  */
  @Valid 
  @Schema(name = "creationDate", description = "the date the trade was accepted", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creationDate")
  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public TradeStatusDTO status(com.nepflow.PollenExchange.Model.TradeRating.RATING status) {
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
  public com.nepflow.PollenExchange.Model.TradeRating.RATING getStatus() {
    return status;
  }

  public void setStatus(com.nepflow.PollenExchange.Model.TradeRating.RATING status) {
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
    TradeStatusDTO tradeStatusDTO = (TradeStatusDTO) o;
    return Objects.equals(this.tradeId, tradeStatusDTO.tradeId) &&
        Objects.equals(this.creationDate, tradeStatusDTO.creationDate) &&
        Objects.equals(this.status, tradeStatusDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, creationDate, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeStatusDTO {\n");
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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

