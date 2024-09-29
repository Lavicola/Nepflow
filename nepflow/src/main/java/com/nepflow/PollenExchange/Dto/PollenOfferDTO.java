package com.nepflow.PollenExchange.Dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nepflow.PollenExchange.Dto.UserDTO;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PollenOfferDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-29T23:21:38.328386900+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class PollenOfferDTO {

  private String id;

  private UserDTO user;

  private String nepenthesName;

  private String cloneId;

  private String sex;

  private String location;

  private String seller;

  private String imageLocation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate pollenOfferOpenedDate;

  public PollenOfferDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PollenOfferDTO user(UserDTO user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @Valid 
  @Schema(name = "user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user")
  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public PollenOfferDTO nepenthesName(String nepenthesName) {
    this.nepenthesName = nepenthesName;
    return this;
  }

  /**
   * Get nepenthesName
   * @return nepenthesName
  */
  
  @Schema(name = "nepenthesName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nepenthesName")
  public String getNepenthesName() {
    return nepenthesName;
  }

  public void setNepenthesName(String nepenthesName) {
    this.nepenthesName = nepenthesName;
  }

  public PollenOfferDTO cloneId(String cloneId) {
    this.cloneId = cloneId;
    return this;
  }

  /**
   * Get cloneId
   * @return cloneId
  */
  
  @Schema(name = "cloneId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cloneId")
  public String getCloneId() {
    return cloneId;
  }

  public void setCloneId(String cloneId) {
    this.cloneId = cloneId;
  }

  public PollenOfferDTO sex(String sex) {
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

  public PollenOfferDTO location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  
  @Schema(name = "location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public PollenOfferDTO seller(String seller) {
    this.seller = seller;
    return this;
  }

  /**
   * Get seller
   * @return seller
  */
  
  @Schema(name = "seller", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seller")
  public String getSeller() {
    return seller;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }

  public PollenOfferDTO imageLocation(String imageLocation) {
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

  public PollenOfferDTO pollenOfferOpenedDate(LocalDate pollenOfferOpenedDate) {
    this.pollenOfferOpenedDate = pollenOfferOpenedDate;
    return this;
  }

  /**
   * Get pollenOfferOpenedDate
   * @return pollenOfferOpenedDate
  */
  @Valid 
  @Schema(name = "pollenOfferOpenedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pollenOfferOpenedDate")
  public LocalDate getPollenOfferOpenedDate() {
    return pollenOfferOpenedDate;
  }

  public void setPollenOfferOpenedDate(LocalDate pollenOfferOpenedDate) {
    this.pollenOfferOpenedDate = pollenOfferOpenedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PollenOfferDTO pollenOfferDTO = (PollenOfferDTO) o;
    return Objects.equals(this.id, pollenOfferDTO.id) &&
        Objects.equals(this.user, pollenOfferDTO.user) &&
        Objects.equals(this.nepenthesName, pollenOfferDTO.nepenthesName) &&
        Objects.equals(this.cloneId, pollenOfferDTO.cloneId) &&
        Objects.equals(this.sex, pollenOfferDTO.sex) &&
        Objects.equals(this.location, pollenOfferDTO.location) &&
        Objects.equals(this.seller, pollenOfferDTO.seller) &&
        Objects.equals(this.imageLocation, pollenOfferDTO.imageLocation) &&
        Objects.equals(this.pollenOfferOpenedDate, pollenOfferDTO.pollenOfferOpenedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, nepenthesName, cloneId, sex, location, seller, imageLocation, pollenOfferOpenedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PollenOfferDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    nepenthesName: ").append(toIndentedString(nepenthesName)).append("\n");
    sb.append("    cloneId: ").append(toIndentedString(cloneId)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
    sb.append("    imageLocation: ").append(toIndentedString(imageLocation)).append("\n");
    sb.append("    pollenOfferOpenedDate: ").append(toIndentedString(pollenOfferOpenedDate)).append("\n");
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

