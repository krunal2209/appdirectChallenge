package org.appdirect.challenge.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.appdirect.challenge.dto.OrderItems;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-18T18:45:19.434-04:00")

public class Order   {
  @JsonProperty("editionCode")
  private String editionCode = null;

  @JsonProperty("pricingDuration")
  private String pricingDuration = null;

  @JsonProperty("items")
  private List<OrderItems> items = null;

  public Order editionCode(String editionCode) {
    this.editionCode = editionCode;
    return this;
  }

   /**
   * Get editionCode
   * @return editionCode
  **/
  @ApiModelProperty(value = "")


  public String getEditionCode() {
    return editionCode;
  }

  public void setEditionCode(String editionCode) {
    this.editionCode = editionCode;
  }

  public Order pricingDuration(String pricingDuration) {
    this.pricingDuration = pricingDuration;
    return this;
  }

   /**
   * Get pricingDuration
   * @return pricingDuration
  **/
  @ApiModelProperty(value = "")


  public String getPricingDuration() {
    return pricingDuration;
  }

  public void setPricingDuration(String pricingDuration) {
    this.pricingDuration = pricingDuration;
  }

  public Order items(List<OrderItems> items) {
    this.items = items;
    return this;
  }

  public Order addItemsItem(OrderItems itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<OrderItems>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OrderItems> getItems() {
    return items;
  }

  public void setItems(List<OrderItems> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.editionCode, order.editionCode) &&
        Objects.equals(this.pricingDuration, order.pricingDuration) &&
        Objects.equals(this.items, order.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(editionCode, pricingDuration, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    editionCode: ").append(toIndentedString(editionCode)).append("\n");
    sb.append("    pricingDuration: ").append(toIndentedString(pricingDuration)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

