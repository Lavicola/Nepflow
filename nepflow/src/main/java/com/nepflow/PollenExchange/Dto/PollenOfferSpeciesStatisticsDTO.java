package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * PollenOfferSpeciesStatisticsDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class PollenOfferSpeciesStatisticsDTO {

  private String specimenId;

  private Integer floweringCount;

  private String cloneId;

  private String nepenthesName;

  public PollenOfferSpeciesStatisticsDTO specimenId(String specimenId) {
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

  public PollenOfferSpeciesStatisticsDTO floweringCount(Integer floweringCount) {
    this.floweringCount = floweringCount;
    return this;
  }

  /**
   * Get floweringCount
   * @return floweringCount
  */
  
  @Schema(name = "floweringCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("floweringCount")
  public Integer getFloweringCount() {
    return floweringCount;
  }

  public void setFloweringCount(Integer floweringCount) {
    this.floweringCount = floweringCount;
  }

  public PollenOfferSpeciesStatisticsDTO cloneId(String cloneId) {
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

  public PollenOfferSpeciesStatisticsDTO nepenthesName(String nepenthesName) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PollenOfferSpeciesStatisticsDTO pollenOfferSpeciesStatisticsDTO = (PollenOfferSpeciesStatisticsDTO) o;
    return Objects.equals(this.specimenId, pollenOfferSpeciesStatisticsDTO.specimenId) &&
        Objects.equals(this.floweringCount, pollenOfferSpeciesStatisticsDTO.floweringCount) &&
        Objects.equals(this.cloneId, pollenOfferSpeciesStatisticsDTO.cloneId) &&
        Objects.equals(this.nepenthesName, pollenOfferSpeciesStatisticsDTO.nepenthesName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(specimenId, floweringCount, cloneId, nepenthesName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PollenOfferSpeciesStatisticsDTO {\n");
    sb.append("    specimenId: ").append(toIndentedString(specimenId)).append("\n");
    sb.append("    floweringCount: ").append(toIndentedString(floweringCount)).append("\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    nepenthesName: ").append(toIndentedString(nepenthesName)).append("\n");
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

