package com.nepflow.NepenthesManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * HybridCloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T22:42:44.669728600+02:00[Europe/Berlin]")
public class HybridCloneDTO implements CloneGrexDTOFather {

  private LabelDTO label;

  private String cloneId;

  private String internalcloneId;

  private String sex;

  private CloneGrexDTO grex;

  private String producer;

  private String location;

  private String fatherName;

  private String motherName;

  public HybridCloneDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public HybridCloneDTO(LabelDTO label) {
    this.label = label;
  }

  public HybridCloneDTO label(LabelDTO label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  */
  @NotNull @Valid 
  @Schema(name = "label", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("label")
  public LabelDTO getLabel() {
    return label;
  }

  public void setLabel(LabelDTO label) {
    this.label = label;
  }

  public HybridCloneDTO cloneId(String cloneId) {
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

  public HybridCloneDTO internalcloneId(String internalcloneId) {
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

  public HybridCloneDTO sex(String sex) {
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

  public HybridCloneDTO grex(CloneGrexDTO grex) {
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

  public HybridCloneDTO producer(String producer) {
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

  public HybridCloneDTO location(String location) {
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

  public HybridCloneDTO fatherName(String fatherName) {
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

  public HybridCloneDTO motherName(String motherName) {
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
    HybridCloneDTO hybridCloneDTO = (HybridCloneDTO) o;
    return Objects.equals(this.label, hybridCloneDTO.label) &&
        Objects.equals(this.cloneId, hybridCloneDTO.cloneId) &&
        Objects.equals(this.internalcloneId, hybridCloneDTO.internalcloneId) &&
        Objects.equals(this.sex, hybridCloneDTO.sex) &&
        Objects.equals(this.grex, hybridCloneDTO.grex) &&
        Objects.equals(this.producer, hybridCloneDTO.producer) &&
        Objects.equals(this.location, hybridCloneDTO.location) &&
        Objects.equals(this.fatherName, hybridCloneDTO.fatherName) &&
        Objects.equals(this.motherName, hybridCloneDTO.motherName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, cloneId, internalcloneId, sex, grex, producer, location, fatherName, motherName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HybridCloneDTO {\n");
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

