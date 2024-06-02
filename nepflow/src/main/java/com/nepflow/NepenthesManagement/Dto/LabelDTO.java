package com.nepflow.NepenthesManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * LabelDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T22:42:44.669728600+02:00[Europe/Berlin]")
public class LabelDTO {

  private String name;

  private String prefix;

  public LabelDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LabelDTO prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

  /**
   * Get prefix
   * @return prefix
  */
  
  @Schema(name = "prefix", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prefix")
  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelDTO labelDTO = (LabelDTO) o;
    return Objects.equals(this.name, labelDTO.name) &&
        Objects.equals(this.prefix, labelDTO.prefix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, prefix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabelDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
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

