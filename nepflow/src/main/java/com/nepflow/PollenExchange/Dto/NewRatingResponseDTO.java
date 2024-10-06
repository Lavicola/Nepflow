package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * NewRatingResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class NewRatingResponseDTO {

  private String comment;

  private String imageLocation;

  private com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType;

  public NewRatingResponseDTO comment(String comment) {
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

  public NewRatingResponseDTO imageLocation(String imageLocation) {
    this.imageLocation = imageLocation;
    return this;
  }

  /**
   * Get imageLocation
   * @return imageLocation
  */
  
  @Schema(name = "imageLocation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageLocation")
  public String getImageLocation() {
    return imageLocation;
  }

  public void setImageLocation(String imageLocation) {
    this.imageLocation = imageLocation;
  }

  public NewRatingResponseDTO reviewType(com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType) {
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
    NewRatingResponseDTO newRatingResponseDTO = (NewRatingResponseDTO) o;
    return Objects.equals(this.comment, newRatingResponseDTO.comment) &&
        Objects.equals(this.imageLocation, newRatingResponseDTO.imageLocation) &&
        Objects.equals(this.reviewType, newRatingResponseDTO.reviewType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, imageLocation, reviewType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewRatingResponseDTO {\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    imageLocation: ").append(toIndentedString(imageLocation)).append("\n");
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

