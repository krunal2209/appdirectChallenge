package org.appdirect.challenge.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-18T18:45:19.434-04:00")

public class Response   {
  @JsonProperty("success")
  private Boolean success = null;

  @JsonProperty("accountIdentifier")
  private String accountIdentifier = null;

  /**
   * Gets or Sets errorCode
   */
  public enum ErrorCodeEnum {
    USER_ALREADY_EXISTS("USER_ALREADY_EXISTS"),
    
    USER_NOT_FOUND("USER_NOT_FOUND"),
    
    ACCOUNT_NOT_FOUND("ACCOUNT_NOT_FOUND"),
    
    MAX_USERS_REACHED("MAX_USERS_REACHED"),
    
    UNAUTHORIZED("UNAUTHORIZED"),
    
    OPERATION_CANCELED("OPERATION_CANCELED"),
    
    CONFIGURATION_ERROR("CONFIGURATION_ERROR"),
    
    INVALID_RESPONSE("INVALID_RESPONSE"),
    
    PENDING("PENDING"),
    
    FORBIDDEN("FORBIDDEN"),
    
    BINDING_NOT_FOUND("BINDING_NOT_FOUND"),
    
    TRANSPORT_ERROR("TRANSPORT_ERROR"),
    
    UNKNOWN_ERROR("UNKNOWN_ERROR");

    private String value;

    ErrorCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorCodeEnum fromValue(String text) {
      for (ErrorCodeEnum b : ErrorCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("errorCode")
  private ErrorCodeEnum errorCode = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("userIdentifier")
  private String userIdentifier = null;

  public Response success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  @ApiModelProperty(value = "")


  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public Response accountIdentifier(String accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

   /**
   * Get accountIdentifier
   * @return accountIdentifier
  **/
  @ApiModelProperty(value = "")


  public String getAccountIdentifier() {
    return accountIdentifier;
  }

  public void setAccountIdentifier(String accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  public Response errorCode(ErrorCodeEnum errorCode) {
    this.errorCode = errorCode;
    return this;
  }

   /**
   * Get errorCode
   * @return errorCode
  **/
  @ApiModelProperty(value = "")


  public ErrorCodeEnum getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCodeEnum errorCode) {
    this.errorCode = errorCode;
  }

  public Response message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Response userIdentifier(String userIdentifier) {
    this.userIdentifier = userIdentifier;
    return this;
  }

   /**
   * Get userIdentifier
   * @return userIdentifier
  **/
  @ApiModelProperty(value = "")


  public String getUserIdentifier() {
    return userIdentifier;
  }

  public void setUserIdentifier(String userIdentifier) {
    this.userIdentifier = userIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response response = (Response) o;
    return Objects.equals(this.success, response.success) &&
        Objects.equals(this.accountIdentifier, response.accountIdentifier) &&
        Objects.equals(this.errorCode, response.errorCode) &&
        Objects.equals(this.message, response.message) &&
        Objects.equals(this.userIdentifier, response.userIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, accountIdentifier, errorCode, message, userIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    userIdentifier: ").append(toIndentedString(userIdentifier)).append("\n");
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

