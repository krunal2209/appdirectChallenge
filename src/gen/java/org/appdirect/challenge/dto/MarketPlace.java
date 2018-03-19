package org.appdirect.challenge.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MarketPlace
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-18T18:45:19.434-04:00")

public class MarketPlace   {
  @JsonProperty("baseUrl")
  private String baseUrl = null;

  @JsonProperty("partner")
  private String partner = null;

  public MarketPlace baseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
    return this;
  }

   /**
   * Get baseUrl
   * @return baseUrl
  **/
  @ApiModelProperty(value = "")


  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public MarketPlace partner(String partner) {
    this.partner = partner;
    return this;
  }

   /**
   * Get partner
   * @return partner
  **/
  @ApiModelProperty(value = "")


  public String getPartner() {
    return partner;
  }

  public void setPartner(String partner) {
    this.partner = partner;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarketPlace marketPlace = (MarketPlace) o;
    return Objects.equals(this.baseUrl, marketPlace.baseUrl) &&
        Objects.equals(this.partner, marketPlace.partner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseUrl, partner);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarketPlace {\n");
    
    sb.append("    baseUrl: ").append(toIndentedString(baseUrl)).append("\n");
    sb.append("    partner: ").append(toIndentedString(partner)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

