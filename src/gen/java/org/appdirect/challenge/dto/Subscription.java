package org.appdirect.challenge.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.appdirect.challenge.dto.MarketPlace;
import org.appdirect.challenge.dto.Payload;
import org.appdirect.challenge.dto.User;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Subscription
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-18T18:45:19.434-04:00")

public class Subscription   {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ORDER("SUBSCRIPTION_ORDER"),
    
    CANCEL("SUBSCRIPTION_CANCEL");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("marketPlace")
  private MarketPlace marketPlace = null;

  @JsonProperty("applicationUuid")
  private String applicationUuid = null;

  /**
   * Gets or Sets flag
   */
  public enum FlagEnum {
    STATELESS("STATELESS"),
    
    DEVELOPMENT("DEVELOPMENT");

    private String value;

    FlagEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FlagEnum fromValue(String text) {
      for (FlagEnum b : FlagEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("flag")
  private FlagEnum flag = null;

  @JsonProperty("returnUrl")
  private String returnUrl = null;

  @JsonProperty("creator")
  private User creator = null;

  @JsonProperty("payload")
  private Payload payload = null;

  public Subscription type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Subscription marketPlace(MarketPlace marketPlace) {
    this.marketPlace = marketPlace;
    return this;
  }

   /**
   * Get marketPlace
   * @return marketPlace
  **/
  @ApiModelProperty(value = "")

  @Valid

  public MarketPlace getMarketPlace() {
    return marketPlace;
  }

  public void setMarketPlace(MarketPlace marketPlace) {
    this.marketPlace = marketPlace;
  }

  public Subscription applicationUuid(String applicationUuid) {
    this.applicationUuid = applicationUuid;
    return this;
  }

   /**
   * Get applicationUuid
   * @return applicationUuid
  **/
  @ApiModelProperty(value = "")


  public String getApplicationUuid() {
    return applicationUuid;
  }

  public void setApplicationUuid(String applicationUuid) {
    this.applicationUuid = applicationUuid;
  }

  public Subscription flag(FlagEnum flag) {
    this.flag = flag;
    return this;
  }

   /**
   * Get flag
   * @return flag
  **/
  @ApiModelProperty(value = "")


  public FlagEnum getFlag() {
    return flag;
  }

  public void setFlag(FlagEnum flag) {
    this.flag = flag;
  }

  public Subscription returnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
    return this;
  }

   /**
   * Get returnUrl
   * @return returnUrl
  **/
  @ApiModelProperty(value = "")


  public String getReturnUrl() {
    return returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public Subscription creator(User creator) {
    this.creator = creator;
    return this;
  }

   /**
   * Get creator
   * @return creator
  **/
  @ApiModelProperty(value = "")

  @Valid

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public Subscription payload(Payload payload) {
    this.payload = payload;
    return this;
  }

   /**
   * Get payload
   * @return payload
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Payload getPayload() {
    return payload;
  }

  public void setPayload(Payload payload) {
    this.payload = payload;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscription subscription = (Subscription) o;
    return Objects.equals(this.type, subscription.type) &&
        Objects.equals(this.marketPlace, subscription.marketPlace) &&
        Objects.equals(this.applicationUuid, subscription.applicationUuid) &&
        Objects.equals(this.flag, subscription.flag) &&
        Objects.equals(this.returnUrl, subscription.returnUrl) &&
        Objects.equals(this.creator, subscription.creator) &&
        Objects.equals(this.payload, subscription.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, marketPlace, applicationUuid, flag, returnUrl, creator, payload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscription {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    marketPlace: ").append(toIndentedString(marketPlace)).append("\n");
    sb.append("    applicationUuid: ").append(toIndentedString(applicationUuid)).append("\n");
    sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
    sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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

