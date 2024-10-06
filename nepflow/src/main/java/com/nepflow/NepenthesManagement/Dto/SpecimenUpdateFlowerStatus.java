package com.nepflow.NepenthesManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * SpecimenUpdateFlowerStatus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-19T17:31:01.094750100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class SpecimenUpdateFlowerStatus {

  private Boolean isFlowering;

  public SpecimenUpdateFlowerStatus isFlowering(Boolean isFlowering) {
    this.isFlowering = isFlowering;
    return this;
  }

  /**
   * Get isFlowering
   * @return isFlowering
  */
  
  @Schema(name = "isFlowering", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isFlowering")
  public Boolean getIsFlowering() {
    return isFlowering;
  }

  public void setIsFlowering(Boolean isFlowering) {
    this.isFlowering = isFlowering;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecimenUpdateFlowerStatus specimenUpdateFlowerStatus = (SpecimenUpdateFlowerStatus) o;
    return Objects.equals(this.isFlowering, specimenUpdateFlowerStatus.isFlowering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isFlowering);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecimenUpdateFlowerStatus {\n");
    sb.append("    isFlowering: ").append(toIndentedString(isFlowering)).append("\n");
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

