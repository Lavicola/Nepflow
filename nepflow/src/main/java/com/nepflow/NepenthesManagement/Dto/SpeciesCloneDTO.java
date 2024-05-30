package com.nepflow.NepenthesManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * SpeciesCloneDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-15T23:01:09.594573900+02:00[Europe/Berlin]")
public class SpeciesCloneDTO implements CloneGrexDTOFather {

  private String cloneId;

  private String name;

  private String sex;

  private CloneGrexDTO grex;

  private String producer;

  private String nepenthes;

  private String location;

  public SpeciesCloneDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpeciesCloneDTO(String name, String sex, String nepenthes) {
    this.name = name;
    this.sex = sex;
    this.nepenthes = nepenthes;
  }

  public SpeciesCloneDTO cloneId(String cloneId) {
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

  public SpeciesCloneDTO name(String name) {
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

  public SpeciesCloneDTO sex(String sex) {
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

  public SpeciesCloneDTO grex(CloneGrexDTO grex) {
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

  public SpeciesCloneDTO producer(String producer) {
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

  public SpeciesCloneDTO nepenthes(String nepenthes) {
    this.nepenthes = nepenthes;
    return this;
  }

  /**
   * Get nepenthes
   * @return nepenthes
  */
  @NotNull 
  @Schema(name = "nepenthes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nepenthes")
  public String getNepenthes() {
    return nepenthes;
  }

  public void setNepenthes(String nepenthes) {
    this.nepenthes = nepenthes;
  }

  public SpeciesCloneDTO location(String location) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpeciesCloneDTO speciesCloneDTO = (SpeciesCloneDTO) o;
    return Objects.equals(this.cloneId, speciesCloneDTO.cloneId) &&
        Objects.equals(this.name, speciesCloneDTO.name) &&
        Objects.equals(this.sex, speciesCloneDTO.sex) &&
        Objects.equals(this.grex, speciesCloneDTO.grex) &&
        Objects.equals(this.producer, speciesCloneDTO.producer) &&
        Objects.equals(this.nepenthes, speciesCloneDTO.nepenthes) &&
        Objects.equals(this.location, speciesCloneDTO.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloneId, name, sex, grex, producer, nepenthes, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeciesCloneDTO {\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    grex: ").append(toIndentedString(grex)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
    sb.append("    nepenthes: ").append(toIndentedString(nepenthes)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

