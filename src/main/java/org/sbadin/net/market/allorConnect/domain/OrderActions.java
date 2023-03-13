package org.sbadin.net.market.allorConnect.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
 public class OrderActions {

   @JsonProperty("message")
   private String message;

   @JsonProperty("orderNumber")
   private String orderNumber;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
     return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
         .append("message", message)
         .append("orderNumber", orderNumber)
         .toString();
   }
 }
