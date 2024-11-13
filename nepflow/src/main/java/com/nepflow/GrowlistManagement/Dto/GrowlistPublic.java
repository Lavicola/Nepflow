package com.nepflow.GrowlistManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * GrowlistPublic
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T23:31:26.301276400+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class GrowlistPublic {

  private Boolean isPublic;

  public GrowlistPublic isPublic(Boolean isPublic) {
    this.isPublic = isPublic;
    return this;
  }

  /**
   * Get isPublic
   * @return isPublic
  */
  
  @Schema(name = "isPublic", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isPublic")
  public Boolean getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrowlistPublic growlistPublic = (GrowlistPublic) o;
    return Objects.equals(this.isPublic, growlistPublic.isPublic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isPublic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GrowlistPublic {\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
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

