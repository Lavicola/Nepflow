package com.nepflow.GrowlistManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * SpecimenUpdateSex
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-01T00:08:47.441615400+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class SpecimenUpdateSex {

  private String sex;

  public SpecimenUpdateSex sex(String sex) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecimenUpdateSex specimenUpdateSex = (SpecimenUpdateSex) o;
    return Objects.equals(this.sex, specimenUpdateSex.sex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecimenUpdateSex {\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
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

