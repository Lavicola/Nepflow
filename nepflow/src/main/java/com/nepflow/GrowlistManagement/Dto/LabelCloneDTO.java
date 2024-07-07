package com.nepflow.GrowlistManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * LabelCloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-06T21:22:32.607237200+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class LabelCloneDTO {

  private LabelDTO label;

  private CloneDTO clone;

  public LabelCloneDTO label(LabelDTO label) {
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

  public LabelCloneDTO clone(CloneDTO clone) {
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
  public CloneDTO getClone() {
    return clone;
  }

  public void setClone(CloneDTO clone) {
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
    LabelCloneDTO labelCloneDTO = (LabelCloneDTO) o;
    return Objects.equals(this.label, labelCloneDTO.label) &&
        Objects.equals(this.clone, labelCloneDTO.clone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, clone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabelCloneDTO {\n");
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

