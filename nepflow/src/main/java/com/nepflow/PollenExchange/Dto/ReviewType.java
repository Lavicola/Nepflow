package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Gets or Sets ReviewType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public enum ReviewType {
  
  SUCCESS("SUCCESS"),
  
  FAILURE("FAILURE"),
  
  PENDING("PENDING");

  private String value;

  ReviewType(String value) {
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
  public static ReviewType fromValue(String value) {
    for (ReviewType b : ReviewType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

