package com.nepflow.ChatModule.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Objects;

/**
 * NewMessageDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-05T00:20:35.211257800+01:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class NewMessageDTO {

  private String content;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant timestamp;

  public NewMessageDTO content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  */
  
  @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public NewMessageDTO timestamp(Instant timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  */
  @Valid 
  @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewMessageDTO newMessageDTO = (NewMessageDTO) o;
    return Objects.equals(this.content, newMessageDTO.content) &&
        Objects.equals(this.timestamp, newMessageDTO.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewMessageDTO {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

