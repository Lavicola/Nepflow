package com.nepflow.GrowlistManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LabelClonesDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-01T00:08:47.441615400+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class LabelClonesDTO {

  private LabelDTO label;

  @Valid
  private List<@Valid CloneDTO> clones = new ArrayList<>();

  public LabelClonesDTO label(LabelDTO label) {
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

  public LabelClonesDTO clones(List<@Valid CloneDTO> clones) {
    this.clones = clones;
    return this;
  }

  public LabelClonesDTO addClonesItem(CloneDTO clonesItem) {
    if (this.clones == null) {
      this.clones = new ArrayList<>();
    }
    this.clones.add(clonesItem);
    return this;
  }

  /**
   * Get clones
   * @return clones
  */
  @Valid 
  @Schema(name = "clones", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clones")
  public List<@Valid CloneDTO> getClones() {
    return clones;
  }

  public void setClones(List<@Valid CloneDTO> clones) {
    this.clones = clones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelClonesDTO labelClonesDTO = (LabelClonesDTO) o;
    return Objects.equals(this.label, labelClonesDTO.label) &&
        Objects.equals(this.clones, labelClonesDTO.clones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, clones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabelClonesDTO {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    clones: ").append(toIndentedString(clones)).append("\n");
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

