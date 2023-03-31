package org.sbadin.net.market.allorConnect.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sbadin.net.market.allorConnect.domain.general.Instrument;
import org.sbadin.net.market.allorConnect.domain.general.User;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
 public class MarketStoplossRequest {
    @JsonProperty("side")
    private Side side;

    @JsonProperty("condition")
    private Condition condition;
    @JsonProperty("triggerPrice")
    private BigDecimal triggerPrice;
    @JsonProperty("stopEndUnixTime")
    private Long orderEndUnixTime;

    @JsonProperty("quantity")
    private Integer quantity;

   @JsonProperty("instrument")
   private Instrument instrument;

    @JsonProperty("user")
    private User user;

    @Override
    public String toString() {
     return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
         .append("quantity", quantity)
         .append("side", side)
         .append("condition", condition)
         .append("triggerPrice", triggerPrice)
         .append("orderEndUnixTime", orderEndUnixTime)
         .append("instrument", instrument)
         .append("user", user)
         .toString();
   }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public BigDecimal getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public Long getOrderEndUnixTime() {
        return orderEndUnixTime;
    }

    public void setOrderEndUnixTime(Long orderEndUnixTime) {
        this.orderEndUnixTime = orderEndUnixTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
