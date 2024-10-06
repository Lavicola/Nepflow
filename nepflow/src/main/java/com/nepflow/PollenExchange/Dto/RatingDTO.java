package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * RatingDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class RatingDTO {

  private String tradeId;

  private String comment;

  private String rater;

  private String receivedOn;

  private org.springframework.web.multipart.MultipartFile file;

  private com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType;

  public RatingDTO tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  /**
   * Get tradeId
   * @return tradeId
  */
  
  @Schema(name = "tradeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tradeId")
  public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public RatingDTO comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
  */
  
  @Schema(name = "comment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public RatingDTO rater(String rater) {
    this.rater = rater;
    return this;
  }

  /**
   * Get rater
   * @return rater
  */
  
  @Schema(name = "rater", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rater")
  public String getRater() {
    return rater;
  }

  public void setRater(String rater) {
    this.rater = rater;
  }

  public RatingDTO receivedOn(String receivedOn) {
    this.receivedOn = receivedOn;
    return this;
  }

  /**
   * Get receivedOn
   * @return receivedOn
  */
  
  @Schema(name = "receivedOn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("receivedOn")
  public String getReceivedOn() {
    return receivedOn;
  }

  public void setReceivedOn(String receivedOn) {
    this.receivedOn = receivedOn;
  }

  public RatingDTO file(org.springframework.web.multipart.MultipartFile file) {
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

  public RatingDTO reviewType(com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType) {
    this.reviewType = reviewType;
    return this;
  }

  /**
   * Get reviewType
   * @return reviewType
  */
  @Valid 
  @Schema(name = "reviewType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reviewType")
  public com.nepflow.PollenExchange.Model.TradeRating.RATING getReviewType() {
    return reviewType;
  }

  public void setReviewType(com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType) {
    this.reviewType = reviewType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RatingDTO ratingDTO = (RatingDTO) o;
    return Objects.equals(this.tradeId, ratingDTO.tradeId) &&
        Objects.equals(this.comment, ratingDTO.comment) &&
        Objects.equals(this.rater, ratingDTO.rater) &&
        Objects.equals(this.receivedOn, ratingDTO.receivedOn) &&
        Objects.equals(this.file, ratingDTO.file) &&
        Objects.equals(this.reviewType, ratingDTO.reviewType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, comment, rater, receivedOn, file, reviewType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatingDTO {\n");
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    rater: ").append(toIndentedString(rater)).append("\n");
    sb.append("    receivedOn: ").append(toIndentedString(receivedOn)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    reviewType: ").append(toIndentedString(reviewType)).append("\n");
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

