package com.nepflow.GrowlistManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CloneType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-20T23:57:23.701653200+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
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

