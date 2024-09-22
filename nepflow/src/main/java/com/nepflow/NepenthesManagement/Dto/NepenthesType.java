package com.nepflow.NepenthesManagement.Dto;

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
 * Gets or Sets NepenthesType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-19T17:31:01.094750100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public enum NepenthesType {
  
  species("Species"),
  
  multihybrid("MultiHybrid"),
  
  primaryhybrid("PrimaryHybrid");

  private String value;

  NepenthesType(String value) {
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
  public static NepenthesType fromValue(String value) {
    for (NepenthesType b : NepenthesType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

