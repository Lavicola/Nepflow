package com.nepflow.NepenthesManagement.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.CloneGrexDTO;
import com.nepflow.NepenthesManagement.Dto.HybridCloneDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LabelClonesDTOClonesInner
 */

@JsonTypeName("LabelClonesDTO_clones_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-30T23:43:49.712163500+02:00[Europe/Berlin]")
public class LabelClonesDTOClonesInner {

  private String label;

  private String cloneId;

  private String internalcloneId;

  private String sex;

  private CloneGrexDTO grex;

  private String producer;

  private String location;

  private String fatherName;

  private String motherName;

  public LabelClonesDTOClonesInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LabelClonesDTOClonesInner(String label) {
    this.label = label;
  }

  public LabelClonesDTOClonesInner label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  */
  @NotNull 
  @Schema(name = "label", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public LabelClonesDTOClonesInner cloneId(String cloneId) {
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

  public LabelClonesDTOClonesInner internalcloneId(String internalcloneId) {
    this.internalcloneId = internalcloneId;
    return this;
  }

  /**
   * Get internalcloneId
   * @return internalcloneId
  */
  
  @Schema(name = "InternalcloneId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("InternalcloneId")
  public String getInternalcloneId() {
    return internalcloneId;
  }

  public void setInternalcloneId(String internalcloneId) {
    this.internalcloneId = internalcloneId;
  }

  public LabelClonesDTOClonesInner sex(String sex) {
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

  public LabelClonesDTOClonesInner grex(CloneGrexDTO grex) {
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

  public LabelClonesDTOClonesInner producer(String producer) {
    this.producer = producer;
    return this;
  }

  /**
   * Get producer
   * @return producer
  */
  
  @Schema(name = "producer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("producer")
  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public LabelClonesDTOClonesInner location(String location) {
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

  public LabelClonesDTOClonesInner fatherName(String fatherName) {
    this.fatherName = fatherName;
    return this;
  }

  /**
   * Get fatherName
   * @return fatherName
  */
  
  @Schema(name = "fatherName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fatherName")
  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public LabelClonesDTOClonesInner motherName(String motherName) {
    this.motherName = motherName;
    return this;
  }

  /**
   * Get motherName
   * @return motherName
  */
  
  @Schema(name = "motherName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("motherName")
  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabelClonesDTOClonesInner labelClonesDTOClonesInner = (LabelClonesDTOClonesInner) o;
    return Objects.equals(this.label, labelClonesDTOClonesInner.label) &&
        Objects.equals(this.cloneId, labelClonesDTOClonesInner.cloneId) &&
        Objects.equals(this.internalcloneId, labelClonesDTOClonesInner.internalcloneId) &&
        Objects.equals(this.sex, labelClonesDTOClonesInner.sex) &&
        Objects.equals(this.grex, labelClonesDTOClonesInner.grex) &&
        Objects.equals(this.producer, labelClonesDTOClonesInner.producer) &&
        Objects.equals(this.location, labelClonesDTOClonesInner.location) &&
        Objects.equals(this.fatherName, labelClonesDTOClonesInner.fatherName) &&
        Objects.equals(this.motherName, labelClonesDTOClonesInner.motherName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, cloneId, internalcloneId, sex, grex, producer, location, fatherName, motherName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabelClonesDTOClonesInner {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    internalcloneId: ").append(toIndentedString(internalcloneId)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    grex: ").append(toIndentedString(grex)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    fatherName: ").append(toIndentedString(fatherName)).append("\n");
    sb.append("    motherName: ").append(toIndentedString(motherName)).append("\n");
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

