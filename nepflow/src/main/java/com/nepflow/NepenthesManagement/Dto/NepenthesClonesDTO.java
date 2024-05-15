package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.NepenthesManagement.Dto.CloneHybridsGet200ResponseInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * NepenthesClonesDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T00:38:12.962208100+02:00[Europe/Berlin]")
public class NepenthesClonesDTO {

  private String nepenthes;

  @Valid
  private List<@Valid CloneHybridsGet200ResponseInner> clones;

  public NepenthesClonesDTO nepenthes(String nepenthes) {
    this.nepenthes = nepenthes;
    return this;
  }

  /**
   * Get nepenthes
   * @return nepenthes
  */
  
  @Schema(name = "nepenthes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nepenthes")
  public String getNepenthes() {
    return nepenthes;
  }

  public void setNepenthes(String nepenthes) {
    this.nepenthes = nepenthes;
  }

  public NepenthesClonesDTO clones(List<@Valid CloneHybridsGet200ResponseInner> clones) {
    this.clones = clones;
    return this;
  }

  public NepenthesClonesDTO addClonesItem(CloneHybridsGet200ResponseInner clonesItem) {
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
  public List<@Valid CloneHybridsGet200ResponseInner> getClones() {
    return clones;
  }

  public void setClones(List<@Valid CloneHybridsGet200ResponseInner> clones) {
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
    NepenthesClonesDTO nepenthesClonesDTO = (NepenthesClonesDTO) o;
    return Objects.equals(this.nepenthes, nepenthesClonesDTO.nepenthes) &&
        Objects.equals(this.clones, nepenthesClonesDTO.clones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nepenthes, clones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NepenthesClonesDTO {\n");
    sb.append("    nepenthes: ").append(toIndentedString(nepenthes)).append("\n");
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

