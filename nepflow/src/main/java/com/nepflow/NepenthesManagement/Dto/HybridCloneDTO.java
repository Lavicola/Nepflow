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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T23:01:09.594573900+02:00[Europe/Berlin]")
public class HybridCloneDTO {

  private String cloneId;

  private String name;

  private String sex;

  private CloneGrexDTO grex;

  private String producer;

  private String fatherName;

  private String motherName;

  public HybridCloneDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public HybridCloneDTO(String name, String sex) {
    this.name = name;
    this.sex = sex;
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

  public HybridCloneDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HybridCloneDTO sex(String sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Get sex
   * @return sex
  */
  @NotNull 
  @Schema(name = "sex", requiredMode = Schema.RequiredMode.REQUIRED)
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
    return Objects.equals(this.cloneId, hybridCloneDTO.cloneId) &&
        Objects.equals(this.name, hybridCloneDTO.name) &&
        Objects.equals(this.sex, hybridCloneDTO.sex) &&
        Objects.equals(this.grex, hybridCloneDTO.grex) &&
        Objects.equals(this.producer, hybridCloneDTO.producer) &&
        Objects.equals(this.fatherName, hybridCloneDTO.fatherName) &&
        Objects.equals(this.motherName, hybridCloneDTO.motherName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloneId, name, sex, grex, producer, fatherName, motherName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HybridCloneDTO {\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    grex: ").append(toIndentedString(grex)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
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

