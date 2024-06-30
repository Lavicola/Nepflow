package com.nepflow.GrowlistManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.GrowlistManagement.Dto.LabelDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LabelSpecimenDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-26T22:21:12.014973900+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class LabelSpecimenDTO {

  private LabelDTO label;

  private SpecimenCloneDTO clone;

  public LabelSpecimenDTO label(LabelDTO label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  */
  @Valid 
  @Schema(name = "label", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("label")
  public LabelDTO getLabel() {
    return label;
  }

  public void setLabel(LabelDTO label) {
    this.label = label;
  }

  public LabelSpecimenDTO clone(SpecimenCloneDTO clone) {
    this.clone = clone;
    return this;
  }

  /**
   * Get clone
   * @return clone
  */
  @Valid 
  @Schema(name = "clone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clone")
  public SpecimenCloneDTO getClone() {
    return clone;
  }

  public void setClone(SpecimenCloneDTO clone) {
    this.clone = clone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelSpecimenDTO labelSpecimenDTO = (LabelSpecimenDTO) o;
    return Objects.equals(this.label, labelSpecimenDTO.label) &&
        Objects.equals(this.clone, labelSpecimenDTO.clone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, clone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabelSpecimenDTO {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    clone: ").append(toIndentedString(clone)).append("\n");
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

