package com.nepflow.ChatModule.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Objects;

/**
 * MessageDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-05T00:20:35.211257800+01:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class MessageDTO {

  private Integer id;

  private String content;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant timestamp;

  private ChatUserDTO sender;

  public MessageDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MessageDTO content(String content) {
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

  public MessageDTO timestamp(Instant timestamp) {
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

  public MessageDTO sender(ChatUserDTO sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
  */
  @Valid 
  @Schema(name = "sender", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sender")
  public ChatUserDTO getSender() {
    return sender;
  }

  public void setSender(ChatUserDTO sender) {
    this.sender = sender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageDTO messageDTO = (MessageDTO) o;
    return Objects.equals(this.id, messageDTO.id) &&
        Objects.equals(this.content, messageDTO.content) &&
        Objects.equals(this.timestamp, messageDTO.timestamp) &&
        Objects.equals(this.sender, messageDTO.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, content, timestamp, sender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
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

