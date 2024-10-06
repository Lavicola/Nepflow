package com.nepflow.PollenExchange.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PollenOfferDateContainerDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-06T01:21:01.231873100+02:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public class PollenOfferDateContainerDTO {

  private String date;

  @Valid
  private List<@Valid PollenOfferDTO> pollenOffers = new ArrayList<>();

  public PollenOfferDateContainerDTO date(String date) {
    this.date = date;
    return this;
  }

  /**
   * MM-YYYY
   * @return date
  */
  
  @Schema(name = "date", description = "MM-YYYY", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public PollenOfferDateContainerDTO pollenOffers(List<@Valid PollenOfferDTO> pollenOffers) {
    this.pollenOffers = pollenOffers;
    return this;
  }

  public PollenOfferDateContainerDTO addPollenOffersItem(PollenOfferDTO pollenOffersItem) {
    if (this.pollenOffers == null) {
      this.pollenOffers = new ArrayList<>();
    }
    this.pollenOffers.add(pollenOffersItem);
    return this;
  }

  /**
   * Get pollenOffers
   * @return pollenOffers
  */
  @Valid 
  @Schema(name = "pollenOffers", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pollenOffers")
  public List<@Valid PollenOfferDTO> getPollenOffers() {
    return pollenOffers;
  }

  public void setPollenOffers(List<@Valid PollenOfferDTO> pollenOffers) {
    this.pollenOffers = pollenOffers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PollenOfferDateContainerDTO pollenOfferDateContainerDTO = (PollenOfferDateContainerDTO) o;
    return Objects.equals(this.date, pollenOfferDateContainerDTO.date) &&
        Objects.equals(this.pollenOffers, pollenOfferDateContainerDTO.pollenOffers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, pollenOffers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PollenOfferDateContainerDTO {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    pollenOffers: ").append(toIndentedString(pollenOffers)).append("\n");
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

