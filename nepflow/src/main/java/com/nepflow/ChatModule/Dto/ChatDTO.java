package com.nepflow.ChatModule.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Chatroom with the 50 newest Messages
 */

@Schema(name = "ChatDTO", description = "Represents a Chatroom with the 50 newest Messages")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-05T00:20:35.211257800+01:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class ChatDTO {

  private Integer id;

  private String name;

  private ChatUserDTO user1;

  private ChatUserDTO user2;

  @Valid
  private List<@Valid MessageDTO> messages = new ArrayList<>();

  public ChatDTO id(Integer id) {
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

  public ChatDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ChatDTO user1(ChatUserDTO user1) {
    this.user1 = user1;
    return this;
  }

  /**
   * Get user1
   * @return user1
  */
  @Valid 
  @Schema(name = "user1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user1")
  public ChatUserDTO getUser1() {
    return user1;
  }

  public void setUser1(ChatUserDTO user1) {
    this.user1 = user1;
  }

  public ChatDTO user2(ChatUserDTO user2) {
    this.user2 = user2;
    return this;
  }

  /**
   * Get user2
   * @return user2
  */
  @Valid 
  @Schema(name = "user2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user2")
  public ChatUserDTO getUser2() {
    return user2;
  }

  public void setUser2(ChatUserDTO user2) {
    this.user2 = user2;
  }

  public ChatDTO messages(List<@Valid MessageDTO> messages) {
    this.messages = messages;
    return this;
  }

  public ChatDTO addMessagesItem(MessageDTO messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Get messages
   * @return messages
  */
  @Valid 
  @Schema(name = "messages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("messages")
  public List<@Valid MessageDTO> getMessages() {
    return messages;
  }

  public void setMessages(List<@Valid MessageDTO> messages) {
    this.messages = messages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatDTO chatDTO = (ChatDTO) o;
    return Objects.equals(this.id, chatDTO.id) &&
        Objects.equals(this.name, chatDTO.name) &&
        Objects.equals(this.user1, chatDTO.user1) &&
        Objects.equals(this.user2, chatDTO.user2) &&
        Objects.equals(this.messages, chatDTO.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, user1, user2, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    user1: ").append(toIndentedString(user1)).append("\n");
    sb.append("    user2: ").append(toIndentedString(user2)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

