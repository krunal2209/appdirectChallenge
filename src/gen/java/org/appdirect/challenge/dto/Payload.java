package org.appdirect.challenge.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.appdirect.challenge.dto.Account;
import org.appdirect.challenge.dto.AddonBinding;
import org.appdirect.challenge.dto.AddonInstance;
import org.appdirect.challenge.dto.Company;
import org.appdirect.challenge.dto.Notice;
import org.appdirect.challenge.dto.Order;
import org.appdirect.challenge.dto.User;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Payload
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-18T18:45:19.434-04:00")

public class Payload   {
  @JsonProperty("user")
  private User user = null;

  @JsonProperty("account")
  private Account account = null;

  @JsonProperty("company")
  private Company company = null;

  @JsonProperty("order")
  private Order order = null;

  @JsonProperty("addonInstance")
  private AddonInstance addonInstance = null;

  @JsonProperty("addonBinding")
  private AddonBinding addonBinding = null;

  @JsonProperty("notice")
  private Notice notice = null;

  public Payload user(User user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")

  @Valid

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Payload account(Account account) {
    this.account = account;
    return this;
  }

   /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Payload company(Company company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Payload order(Order order) {
    this.order = order;
    return this;
  }

   /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Payload addonInstance(AddonInstance addonInstance) {
    this.addonInstance = addonInstance;
    return this;
  }

   /**
   * Get addonInstance
   * @return addonInstance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AddonInstance getAddonInstance() {
    return addonInstance;
  }

  public void setAddonInstance(AddonInstance addonInstance) {
    this.addonInstance = addonInstance;
  }

  public Payload addonBinding(AddonBinding addonBinding) {
    this.addonBinding = addonBinding;
    return this;
  }

   /**
   * Get addonBinding
   * @return addonBinding
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AddonBinding getAddonBinding() {
    return addonBinding;
  }

  public void setAddonBinding(AddonBinding addonBinding) {
    this.addonBinding = addonBinding;
  }

  public Payload notice(Notice notice) {
    this.notice = notice;
    return this;
  }

   /**
   * Get notice
   * @return notice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Notice getNotice() {
    return notice;
  }

  public void setNotice(Notice notice) {
    this.notice = notice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payload payload = (Payload) o;
    return Objects.equals(this.user, payload.user) &&
        Objects.equals(this.account, payload.account) &&
        Objects.equals(this.company, payload.company) &&
        Objects.equals(this.order, payload.order) &&
        Objects.equals(this.addonInstance, payload.addonInstance) &&
        Objects.equals(this.addonBinding, payload.addonBinding) &&
        Objects.equals(this.notice, payload.notice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, account, company, order, addonInstance, addonBinding, notice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payload {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    addonInstance: ").append(toIndentedString(addonInstance)).append("\n");
    sb.append("    addonBinding: ").append(toIndentedString(addonBinding)).append("\n");
    sb.append("    notice: ").append(toIndentedString(notice)).append("\n");
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

