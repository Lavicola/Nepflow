package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.IVCloneDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * NepenthesClonesDTOClone
 */

@JsonTypeName("NepenthesClonesDTO_clone")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-04T15:16:12.326452371+02:00[Europe/Berlin]")
public class NepenthesClonesDTOClone {

  private String id;

  private String nepenthes;

  private String mountain;

  private String sex;

  private String producer;

  public NepenthesClonesDTOClone() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NepenthesClonesDTOClone(String producer) {
    this.producer = producer;
  }

  public NepenthesClonesDTOClone id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public NepenthesClonesDTOClone nepenthes(String nepenthes) {
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

  public NepenthesClonesDTOClone mountain(String mountain) {
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

  public NepenthesClonesDTOClone sex(String sex) {
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

  public NepenthesClonesDTOClone producer(String producer) {
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
    NepenthesClonesDTOClone nepenthesClonesDTOClone = (NepenthesClonesDTOClone) o;
    return Objects.equals(this.id, nepenthesClonesDTOClone.id) &&
        Objects.equals(this.nepenthes, nepenthesClonesDTOClone.nepenthes) &&
        Objects.equals(this.mountain, nepenthesClonesDTOClone.mountain) &&
        Objects.equals(this.sex, nepenthesClonesDTOClone.sex) &&
        Objects.equals(this.producer, nepenthesClonesDTOClone.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nepenthes, mountain, sex, producer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NepenthesClonesDTOClone {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

