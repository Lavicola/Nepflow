package com.nepflow.GrowlistManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * GrowlistClonesSpecimenIdFloweringPatchRequest
 */

@JsonTypeName("_growlist_clones__specimenId__flowering_patch_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-13T22:48:05.044020200+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class GrowlistClonesSpecimenIdFloweringPatchRequest {

  private Boolean flowering;

  public GrowlistClonesSpecimenIdFloweringPatchRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GrowlistClonesSpecimenIdFloweringPatchRequest(Boolean flowering) {
    this.flowering = flowering;
  }

  public GrowlistClonesSpecimenIdFloweringPatchRequest flowering(Boolean flowering) {
    this.flowering = flowering;
    return this;
  }

  /**
   * The flowering status of the clone.
   * @return flowering
  */
  @NotNull 
  @Schema(name = "flowering", description = "The flowering status of the clone.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("flowering")
  public Boolean getFlowering() {
    return flowering;
  }

  public void setFlowering(Boolean flowering) {
    this.flowering = flowering;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrowlistClonesSpecimenIdFloweringPatchRequest growlistClonesSpecimenIdFloweringPatchRequest = (GrowlistClonesSpecimenIdFloweringPatchRequest) o;
    return Objects.equals(this.flowering, growlistClonesSpecimenIdFloweringPatchRequest.flowering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flowering);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GrowlistClonesSpecimenIdFloweringPatchRequest {\n");
    sb.append("    flowering: ").append(toIndentedString(flowering)).append("\n");
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

