package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * NewRatingDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:12:52.918758700+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class NewRatingDTO {

  private org.springframework.web.multipart.MultipartFile file;

  public NewRatingDTO file(org.springframework.web.multipart.MultipartFile file) {
    this.file = file;
    return this;
  }

  /**
   * Get file
   * @return file
  */
  @Valid 
  @Schema(name = "file", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("file")
  public org.springframework.web.multipart.MultipartFile getFile() {
    return file;
  }

  public void setFile(org.springframework.web.multipart.MultipartFile file) {
    this.file = file;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewRatingDTO newRatingDTO = (NewRatingDTO) o;
    return Objects.equals(this.file, newRatingDTO.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewRatingDTO {\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
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

