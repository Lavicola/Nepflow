package com.nepflow.NepenthesManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GrowlistDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-02T19:30:29.653523300+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class GrowlistDTO {

  private String id;

  private String username;

  @Valid
  private List<SpecimenCloneDTO> specimens = new ArrayList<>();

  public GrowlistDTO id(String id) {
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

  public GrowlistDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public GrowlistDTO specimens(List<SpecimenCloneDTO> specimens) {
    this.specimens = specimens;
    return this;
  }

  public GrowlistDTO addSpecimensItem(SpecimenCloneDTO specimensItem) {
    if (this.specimens == null) {
      this.specimens = new ArrayList<>();
    }
    this.specimens.add(specimensItem);
    return this;
  }

  /**
   * Get specimens
   * @return specimens
  */
  @Valid 
  @Schema(name = "specimens", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("specimens")
  public List<SpecimenCloneDTO> getSpecimens() {
    return specimens;
  }

  public void setSpecimens(List<SpecimenCloneDTO> specimens) {
    this.specimens = specimens;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrowlistDTO growlistDTO = (GrowlistDTO) o;
    return Objects.equals(this.id, growlistDTO.id) &&
        Objects.equals(this.username, growlistDTO.username) &&
        Objects.equals(this.specimens, growlistDTO.specimens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, specimens);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GrowlistDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    specimens: ").append(toIndentedString(specimens)).append("\n");
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

