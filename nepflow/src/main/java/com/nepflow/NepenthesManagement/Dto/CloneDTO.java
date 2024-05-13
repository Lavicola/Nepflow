package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-11T01:52:33.806154159+02:00[Europe/Berlin]")
public class CloneDTO {

  private String clonId;

  private String name;

  private String sex;

  public CloneDTO clonId(String clonId) {
    this.clonId = clonId;
    return this;
  }

  /**
   * Get clonId
   * @return clonId
  */
  
  @Schema(name = "clonId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clonId")
  public String getClonId() {
    return clonId;
  }

  public void setClonId(String clonId) {
    this.clonId = clonId;
  }

  public CloneDTO name(String name) {
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

  public CloneDTO sex(String sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Get sex
   * @return sex
  */
  
  @Schema(name = "sex", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sex")
  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloneDTO cloneDTO = (CloneDTO) o;
    return Objects.equals(this.clonId, cloneDTO.clonId) &&
        Objects.equals(this.name, cloneDTO.name) &&
        Objects.equals(this.sex, cloneDTO.sex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clonId, name, sex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloneDTO {\n");
    sb.append("    clonId: ").append(toIndentedString(clonId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
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

