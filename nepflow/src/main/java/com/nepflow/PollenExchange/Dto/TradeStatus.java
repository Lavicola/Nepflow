package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Gets or Sets TradeStatus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T22:16:38.894889700+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public enum TradeStatus {
  
  SUCCESS("SUCCESS"),
  
  FAILURE("FAILURE"),
  
  PENDING("PENDING");

  private String value;

  TradeStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TradeStatus fromValue(String value) {
    for (TradeStatus b : TradeStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

