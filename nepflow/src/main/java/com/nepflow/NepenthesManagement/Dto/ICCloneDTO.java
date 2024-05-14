package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.NepenthesManagement.Dto.CloneGrexDTO;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ICCloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-13T23:03:32.853119600+02:00[Europe/Berlin]")
public class ICCloneDTO implements NepenthesNameCloneGet200Response {

  private String cloneId;

  private String name;

  private String sex;

  private CloneGrexDTO nepenthesName;

  private String location;

  private CloneGrexDTO grex;

  public ICCloneDTO cloneId(String cloneId) {
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

  public ICCloneDTO name(String name) {
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

  public ICCloneDTO sex(String sex) {
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

  public ICCloneDTO nepenthesName(CloneGrexDTO nepenthesName) {
    this.nepenthesName = nepenthesName;
    return this;
  }

  /**
   * Get nepenthesName
   * @return nepenthesName
  */
  @Valid 
  @Schema(name = "nepenthesName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nepenthesName")
  public CloneGrexDTO getNepenthesName() {
    return nepenthesName;
  }

  public void setNepenthesName(CloneGrexDTO nepenthesName) {
    this.nepenthesName = nepenthesName;
  }

  public ICCloneDTO location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  
  @Schema(name = "Location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public ICCloneDTO grex(CloneGrexDTO grex) {
    this.grex = grex;
    return this;
  }

  /**
   * Get grex
   * @return grex
  */
  @Valid 
  @Schema(name = "grex", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("grex")
  public CloneGrexDTO getGrex() {
    return grex;
  }

  public void setGrex(CloneGrexDTO grex) {
    this.grex = grex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ICCloneDTO icCloneDTO = (ICCloneDTO) o;
    return Objects.equals(this.cloneId, icCloneDTO.cloneId) &&
        Objects.equals(this.name, icCloneDTO.name) &&
        Objects.equals(this.sex, icCloneDTO.sex) &&
        Objects.equals(this.nepenthesName, icCloneDTO.nepenthesName) &&
        Objects.equals(this.location, icCloneDTO.location) &&
        Objects.equals(this.grex, icCloneDTO.grex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloneId, name, sex, nepenthesName, location, grex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ICCloneDTO {\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    nepenthesName: ").append(toIndentedString(nepenthesName)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    grex: ").append(toIndentedString(grex)).append("\n");
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

