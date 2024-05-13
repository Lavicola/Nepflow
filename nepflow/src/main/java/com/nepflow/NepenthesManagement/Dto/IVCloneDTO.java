package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-11T01:52:33.806154159+02:00[Europe/Berlin]")
public class IVCloneDTO implements NepenthesNameCloneGet200Response {

  private String clonId;

  private String nepenthes;

  private String mountain;

  private String sex;

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

  public IVCloneDTO clonId(String clonId) {
    this.clonId = clonId;
    return this;
  }

  /**
   * Get clonId
   * @return clonId
  */
  
  @Schema(name = "clonId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clonId")
  public String getClonId() {
    return clonId;
  }

  public void setClonId(String clonId) {
    this.clonId = clonId;
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

  public IVCloneDTO mountain(String mountain) {
    this.mountain = mountain;
    return this;
  }

  /**
   * Get mountain
   * @return mountain
  */
  
  @Schema(name = "mountain", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mountain")
  public String getMountain() {
    return mountain;
  }

  public void setMountain(String mountain) {
    this.mountain = mountain;
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
    return Objects.equals(this.clonId, ivCloneDTO.clonId) &&
        Objects.equals(this.nepenthes, ivCloneDTO.nepenthes) &&
        Objects.equals(this.mountain, ivCloneDTO.mountain) &&
        Objects.equals(this.sex, ivCloneDTO.sex) &&
        Objects.equals(this.producer, ivCloneDTO.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clonId, nepenthes, mountain, sex, producer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IVCloneDTO {\n");
    sb.append("    clonId: ").append(toIndentedString(clonId)).append("\n");
    sb.append("    nepenthes: ").append(toIndentedString(nepenthes)).append("\n");
    sb.append("    mountain: ").append(toIndentedString(mountain)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
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

