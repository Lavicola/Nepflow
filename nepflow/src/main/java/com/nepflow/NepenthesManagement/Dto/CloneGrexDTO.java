package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.NepenthesManagement.Dto.CloneGrexDTOFather;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CloneGrexDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T22:42:44.669728600+02:00[Europe/Berlin]")
public class CloneGrexDTO {

  private String cloneId;

  private CloneGrexDTOFather father;

  private CloneGrexDTOFather mother;

  public CloneGrexDTO cloneId(String cloneId) {
    this.cloneId = cloneId;
    return this;
  }

  /**
   * Get cloneId
   * @return cloneId
  */
  
  @Schema(name = "cloneId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cloneId")
  public String getCloneId() {
    return cloneId;
  }

  public void setCloneId(String cloneId) {
    this.cloneId = cloneId;
  }

  public CloneGrexDTO father(CloneGrexDTOFather father) {
    this.father = father;
    return this;
  }

  /**
   * Get father
   * @return father
  */
  @Valid 
  @Schema(name = "father", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("father")
  public CloneGrexDTOFather getFather() {
    return father;
  }

  public void setFather(CloneGrexDTOFather father) {
    this.father = father;
  }

  public CloneGrexDTO mother(CloneGrexDTOFather mother) {
    this.mother = mother;
    return this;
  }

  /**
   * Get mother
   * @return mother
  */
  @Valid 
  @Schema(name = "mother", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mother")
  public CloneGrexDTOFather getMother() {
    return mother;
  }

  public void setMother(CloneGrexDTOFather mother) {
    this.mother = mother;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloneGrexDTO cloneGrexDTO = (CloneGrexDTO) o;
    return Objects.equals(this.cloneId, cloneGrexDTO.cloneId) &&
        Objects.equals(this.father, cloneGrexDTO.father) &&
        Objects.equals(this.mother, cloneGrexDTO.mother);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloneId, father, mother);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloneGrexDTO {\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    father: ").append(toIndentedString(father)).append("\n");
    sb.append("    mother: ").append(toIndentedString(mother)).append("\n");
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

