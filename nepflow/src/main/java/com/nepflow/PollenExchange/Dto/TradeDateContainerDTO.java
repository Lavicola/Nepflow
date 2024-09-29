package com.nepflow.PollenExchange.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.PollenExchange.Dto.TradeDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TradeDateContainerDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-29T23:21:38.328386900+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeDateContainerDTO {

  private String date;

  @Valid
  private List<@Valid TradeDTO> trades = new ArrayList<>();

  public TradeDateContainerDTO date(String date) {
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

  public TradeDateContainerDTO trades(List<@Valid TradeDTO> trades) {
    this.trades = trades;
    return this;
  }

  public TradeDateContainerDTO addTradesItem(TradeDTO tradesItem) {
    if (this.trades == null) {
      this.trades = new ArrayList<>();
    }
    this.trades.add(tradesItem);
    return this;
  }

  /**
   * Get trades
   * @return trades
  */
  @Valid 
  @Schema(name = "trades", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("trades")
  public List<@Valid TradeDTO> getTrades() {
    return trades;
  }

  public void setTrades(List<@Valid TradeDTO> trades) {
    this.trades = trades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeDateContainerDTO tradeDateContainerDTO = (TradeDateContainerDTO) o;
    return Objects.equals(this.date, tradeDateContainerDTO.date) &&
        Objects.equals(this.trades, tradeDateContainerDTO.trades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, trades);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeDateContainerDTO {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    trades: ").append(toIndentedString(trades)).append("\n");
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

