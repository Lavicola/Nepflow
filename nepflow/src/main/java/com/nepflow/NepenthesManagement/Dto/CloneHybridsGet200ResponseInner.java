package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nepflow.NepenthesManagement.Dto.CloneGrexDTO;
import com.nepflow.NepenthesManagement.Dto.ICCloneDTO;
import com.nepflow.NepenthesManagement.Dto.IVCloneDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CloneHybridsGet200ResponseInner
 */

@JsonTypeName("_clone_hybrids__get_200_response_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T00:38:12.962208100+02:00[Europe/Berlin]")
public class CloneHybridsGet200ResponseInner {

  private String cloneId;

  private String name;

  private String sex;

  private String nepenthes;

  private String location;

  private CloneGrexDTO grex;

  private String producer;

  public CloneHybridsGet200ResponseInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CloneHybridsGet200ResponseInner(String producer) {
    this.producer = producer;
  }

  public CloneHybridsGet200ResponseInner cloneId(String cloneId) {
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

  public CloneHybridsGet200ResponseInner name(String name) {
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

  public CloneHybridsGet200ResponseInner sex(String sex) {
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

  public CloneHybridsGet200ResponseInner nepenthes(String nepenthes) {
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

  public CloneHybridsGet200ResponseInner location(String location) {
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

  public CloneHybridsGet200ResponseInner grex(CloneGrexDTO grex) {
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

  public CloneHybridsGet200ResponseInner producer(String producer) {
    this.producer = producer;
    return this;
  }

  /**
   * Get producer
   * @return producer
  */
  @NotNull 
  @Schema(name = "producer", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("producer")
  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloneHybridsGet200ResponseInner cloneHybridsGet200ResponseInner = (CloneHybridsGet200ResponseInner) o;
    return Objects.equals(this.cloneId, cloneHybridsGet200ResponseInner.cloneId) &&
        Objects.equals(this.name, cloneHybridsGet200ResponseInner.name) &&
        Objects.equals(this.sex, cloneHybridsGet200ResponseInner.sex) &&
        Objects.equals(this.nepenthes, cloneHybridsGet200ResponseInner.nepenthes) &&
        Objects.equals(this.location, cloneHybridsGet200ResponseInner.location) &&
        Objects.equals(this.grex, cloneHybridsGet200ResponseInner.grex) &&
        Objects.equals(this.producer, cloneHybridsGet200ResponseInner.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloneId, name, sex, nepenthes, location, grex, producer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloneHybridsGet200ResponseInner {\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    nepenthes: ").append(toIndentedString(nepenthes)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    grex: ").append(toIndentedString(grex)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
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

