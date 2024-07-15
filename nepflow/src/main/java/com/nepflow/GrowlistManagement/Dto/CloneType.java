package com.nepflow.GrowlistManagement.Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Gets or Sets CloneType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-13T22:57:38.084130600+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public enum CloneType {
  
  iv("iv"),
  
  ic("ic");

  private String value;

  CloneType(String value) {
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
  public static CloneType fromValue(String value) {
    for (CloneType b : CloneType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

