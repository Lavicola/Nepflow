package com.nepflow.NepenthesManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * SpecimenCloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-19T17:31:01.094750100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class SpecimenCloneDTO {

  private String nepenthesName;

  private String cloneId;

  private String internalCloneId;

  private String sex;

  private String description;

  private String nickname;

  private String producer;

  private String location;

  private String specimenId;

  private String filelocation;

  private Boolean isFlowering;

  public SpecimenCloneDTO nepenthesName(String nepenthesName) {
    this.nepenthesName = nepenthesName;
    return this;
  }

  /**
   * Get nepenthesName
   * @return nepenthesName
  */
  
  @Schema(name = "nepenthesName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nepenthesName")
  public String getNepenthesName() {
    return nepenthesName;
  }

  public void setNepenthesName(String nepenthesName) {
    this.nepenthesName = nepenthesName;
  }

  public SpecimenCloneDTO cloneId(String cloneId) {
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

  public SpecimenCloneDTO internalCloneId(String internalCloneId) {
    this.internalCloneId = internalCloneId;
    return this;
  }

  /**
   * Get internalCloneId
   * @return internalCloneId
  */
  
  @Schema(name = "internalCloneId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("internalCloneId")
  public String getInternalCloneId() {
    return internalCloneId;
  }

  public void setInternalCloneId(String internalCloneId) {
    this.internalCloneId = internalCloneId;
  }

  public SpecimenCloneDTO sex(String sex) {
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

  public SpecimenCloneDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SpecimenCloneDTO nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * Get nickname
   * @return nickname
  */
  
  @Schema(name = "nickname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nickname")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public SpecimenCloneDTO producer(String producer) {
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

  public SpecimenCloneDTO location(String location) {
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

  public SpecimenCloneDTO specimenId(String specimenId) {
    this.specimenId = specimenId;
    return this;
  }

  /**
   * Get specimenId
   * @return specimenId
  */
  
  @Schema(name = "specimenId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("specimenId")
  public String getSpecimenId() {
    return specimenId;
  }

  public void setSpecimenId(String specimenId) {
    this.specimenId = specimenId;
  }

  public SpecimenCloneDTO filelocation(String filelocation) {
    this.filelocation = filelocation;
    return this;
  }

  /**
   * Get filelocation
   * @return filelocation
  */
  
  @Schema(name = "filelocation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filelocation")
  public String getFilelocation() {
    return filelocation;
  }

  public void setFilelocation(String filelocation) {
    this.filelocation = filelocation;
  }

  public SpecimenCloneDTO isFlowering(Boolean isFlowering) {
    this.isFlowering = isFlowering;
    return this;
  }

  /**
   * Get isFlowering
   * @return isFlowering
  */
  
  @Schema(name = "isFlowering", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isFlowering")
  public Boolean getIsFlowering() {
    return isFlowering;
  }

  public void setIsFlowering(Boolean isFlowering) {
    this.isFlowering = isFlowering;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecimenCloneDTO specimenCloneDTO = (SpecimenCloneDTO) o;
    return Objects.equals(this.nepenthesName, specimenCloneDTO.nepenthesName) &&
        Objects.equals(this.cloneId, specimenCloneDTO.cloneId) &&
        Objects.equals(this.internalCloneId, specimenCloneDTO.internalCloneId) &&
        Objects.equals(this.sex, specimenCloneDTO.sex) &&
        Objects.equals(this.description, specimenCloneDTO.description) &&
        Objects.equals(this.nickname, specimenCloneDTO.nickname) &&
        Objects.equals(this.producer, specimenCloneDTO.producer) &&
        Objects.equals(this.location, specimenCloneDTO.location) &&
        Objects.equals(this.specimenId, specimenCloneDTO.specimenId) &&
        Objects.equals(this.filelocation, specimenCloneDTO.filelocation) &&
        Objects.equals(this.isFlowering, specimenCloneDTO.isFlowering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nepenthesName, cloneId, internalCloneId, sex, description, nickname, producer, location, specimenId, filelocation, isFlowering);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecimenCloneDTO {\n");
    sb.append("    nepenthesName: ").append(toIndentedString(nepenthesName)).append("\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    internalCloneId: ").append(toIndentedString(internalCloneId)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    specimenId: ").append(toIndentedString(specimenId)).append("\n");
    sb.append("    filelocation: ").append(toIndentedString(filelocation)).append("\n");
    sb.append("    isFlowering: ").append(toIndentedString(isFlowering)).append("\n");
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

