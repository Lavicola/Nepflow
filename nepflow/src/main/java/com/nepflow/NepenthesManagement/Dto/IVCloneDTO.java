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
 * IVCloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T00:38:12.962208100+02:00[Europe/Berlin]")
public class IVCloneDTO implements NepenthesNameCloneGet200Response {

  private String cloneId;

  private String name;

  private String sex;

  private String nepenthes;

  private String location;

  private CloneGrexDTO grex;

  private String producer;

  public IVCloneDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IVCloneDTO(String producer) {
    this.producer = producer;
  }

  public IVCloneDTO cloneId(String cloneId) {
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

  public IVCloneDTO name(String name) {
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

  public IVCloneDTO sex(String sex) {
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

  public IVCloneDTO nepenthes(String nepenthes) {
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

  public IVCloneDTO location(String location) {
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

  public IVCloneDTO grex(CloneGrexDTO grex) {
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

  public IVCloneDTO producer(String producer) {
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
    IVCloneDTO ivCloneDTO = (IVCloneDTO) o;
    return Objects.equals(this.cloneId, ivCloneDTO.cloneId) &&
        Objects.equals(this.name, ivCloneDTO.name) &&
        Objects.equals(this.sex, ivCloneDTO.sex) &&
        Objects.equals(this.nepenthes, ivCloneDTO.nepenthes) &&
        Objects.equals(this.location, ivCloneDTO.location) &&
        Objects.equals(this.grex, ivCloneDTO.grex) &&
        Objects.equals(this.producer, ivCloneDTO.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloneId, name, sex, nepenthes, location, grex, producer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IVCloneDTO {\n");
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

