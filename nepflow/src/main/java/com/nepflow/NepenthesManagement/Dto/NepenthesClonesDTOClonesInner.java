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
 * NepenthesClonesDTOClonesInner
 */

@JsonTypeName("NepenthesClonesDTO_clones_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-04T16:31:16.635966249+02:00[Europe/Berlin]")
public class NepenthesClonesDTOClonesInner {

  private String id;

  private String nepenthes;

  private String mountain;

  private String sex;

  private String producer;

  public NepenthesClonesDTOClonesInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NepenthesClonesDTOClonesInner(String producer) {
    this.producer = producer;
  }

  public NepenthesClonesDTOClonesInner id(String id) {
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

  public NepenthesClonesDTOClonesInner nepenthes(String nepenthes) {
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

  public NepenthesClonesDTOClonesInner mountain(String mountain) {
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

  public NepenthesClonesDTOClonesInner sex(String sex) {
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

  public NepenthesClonesDTOClonesInner producer(String producer) {
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
    NepenthesClonesDTOClonesInner nepenthesClonesDTOClonesInner = (NepenthesClonesDTOClonesInner) o;
    return Objects.equals(this.id, nepenthesClonesDTOClonesInner.id) &&
        Objects.equals(this.nepenthes, nepenthesClonesDTOClonesInner.nepenthes) &&
        Objects.equals(this.mountain, nepenthesClonesDTOClonesInner.mountain) &&
        Objects.equals(this.sex, nepenthesClonesDTOClonesInner.sex) &&
        Objects.equals(this.producer, nepenthesClonesDTOClonesInner.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nepenthes, mountain, sex, producer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NepenthesClonesDTOClonesInner {\n");
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

