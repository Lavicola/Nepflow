package com.nepflow.ChatModule.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Summary of Chatrooms depending on the latest Message.
 */

@Schema(name = "ChatSummaryDTO", description = "Represents a Summary of Chatrooms depending on the latest Message.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-05T00:20:35.211257800+01:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class ChatSummaryDTO {

  @Valid
  private List<@Valid ChatDTO> chats = new ArrayList<>();

  private Integer totalPages;

  public ChatSummaryDTO chats(List<@Valid ChatDTO> chats) {
    this.chats = chats;
    return this;
  }

  public ChatSummaryDTO addChatsItem(ChatDTO chatsItem) {
    if (this.chats == null) {
      this.chats = new ArrayList<>();
    }
    this.chats.add(chatsItem);
    return this;
  }

  /**
   * Get chats
   * @return chats
  */
  @Valid 
  @Schema(name = "chats", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("chats")
  public List<@Valid ChatDTO> getChats() {
    return chats;
  }

  public void setChats(List<@Valid ChatDTO> chats) {
    this.chats = chats;
  }

  public ChatSummaryDTO totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  
  @Schema(name = "totalPages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatSummaryDTO chatSummaryDTO = (ChatSummaryDTO) o;
    return Objects.equals(this.chats, chatSummaryDTO.chats) &&
        Objects.equals(this.totalPages, chatSummaryDTO.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chats, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatSummaryDTO {\n");
    sb.append("    chats: ").append(toIndentedString(chats)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

