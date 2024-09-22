package com.nepflow.GrowlistManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
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
 * SpecimensBulkRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-20T23:57:23.701653200+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class SpecimensBulkRequestDTO {

  @Valid
  private List<SpecimenCloneDTO> success = new ArrayList<>();

  @Valid
  private List<String> failure = new ArrayList<>();

  public SpecimensBulkRequestDTO success(List<SpecimenCloneDTO> success) {
    this.success = success;
    return this;
  }

  public SpecimensBulkRequestDTO addSuccessItem(SpecimenCloneDTO successItem) {
    if (this.success == null) {
      this.success = new ArrayList<>();
    }
    this.success.add(successItem);
    return this;
  }

  /**
   * Get success
   * @return success
  */
  @Valid 
  @Schema(name = "success", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("success")
  public List<SpecimenCloneDTO> getSuccess() {
    return success;
  }

  public void setSuccess(List<SpecimenCloneDTO> success) {
    this.success = success;
  }

  public SpecimensBulkRequestDTO failure(List<String> failure) {
    this.failure = failure;
    return this;
  }

  public SpecimensBulkRequestDTO addFailureItem(String failureItem) {
    if (this.failure == null) {
      this.failure = new ArrayList<>();
    }
    this.failure.add(failureItem);
    return this;
  }

  /**
   * Get failure
   * @return failure
  */
  
  @Schema(name = "failure", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("failure")
  public List<String> getFailure() {
    return failure;
  }

  public void setFailure(List<String> failure) {
    this.failure = failure;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecimensBulkRequestDTO specimensBulkRequestDTO = (SpecimensBulkRequestDTO) o;
    return Objects.equals(this.success, specimensBulkRequestDTO.success) &&
        Objects.equals(this.failure, specimensBulkRequestDTO.failure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, failure);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecimensBulkRequestDTO {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    failure: ").append(toIndentedString(failure)).append("\n");
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

