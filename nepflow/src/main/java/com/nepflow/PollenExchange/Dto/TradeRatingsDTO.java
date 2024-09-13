package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TradeRatingsDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T22:16:38.894889700+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class TradeRatingsDTO {

  private String username;

  @Valid
  private List<@Valid TradeRatingDTO> ratings = new ArrayList<>();

  public TradeRatingsDTO username(String username) {
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

  public TradeRatingsDTO ratings(List<@Valid TradeRatingDTO> ratings) {
    this.ratings = ratings;
    return this;
  }

  public TradeRatingsDTO addRatingsItem(TradeRatingDTO ratingsItem) {
    if (this.ratings == null) {
      this.ratings = new ArrayList<>();
    }
    this.ratings.add(ratingsItem);
    return this;
  }

  /**
   * Get ratings
   * @return ratings
  */
  @Valid 
  @Schema(name = "ratings", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ratings")
  public List<@Valid TradeRatingDTO> getRatings() {
    return ratings;
  }

  public void setRatings(List<@Valid TradeRatingDTO> ratings) {
    this.ratings = ratings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeRatingsDTO tradeRatingsDTO = (TradeRatingsDTO) o;
    return Objects.equals(this.username, tradeRatingsDTO.username) &&
        Objects.equals(this.ratings, tradeRatingsDTO.ratings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, ratings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeRatingsDTO {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    ratings: ").append(toIndentedString(ratings)).append("\n");
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

