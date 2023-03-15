package org.sbadin.net.market.allorConnect.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sbadin.net.market.allorConnect.domain.general.Instrument;
import org.sbadin.net.market.allorConnect.domain.general.User;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
 public class OrderUpdateRequest {

   @JsonProperty("side")
   private Side side;

   @JsonProperty("type")
   private String type;

   @JsonProperty("id")
   private String id;

   @JsonProperty("quantity")
   private Integer quantity;

   @JsonProperty("price")
   private BigDecimal price;

   @JsonProperty("instrument")
   private Instrument instrument;

    @JsonProperty("user")
    private User user;

    @Override
    public String toString() {
     return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
         .append("side", side)
         .append("type", type)
         .append("quantity", quantity)
         .append("id", id)
         .append("price", price)
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void  setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
