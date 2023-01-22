package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractEvent {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("orderno")
  private Integer orderNo;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("qty")
  private Integer qty;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("time")
  private String time;

  @JsonProperty("timestamp")
  private Long timestamp;

  @JsonProperty("side")
  private String side;

  @JsonProperty("oi")
  private Integer oi;

  @JsonProperty("existing")
  private boolean existing;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(Integer orderNo) {
    this.orderNo = orderNo;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public Integer getIo() {
    return oi;
  }

  public void setIo(Integer oi) {
    this.oi = oi;
  }

  public boolean isExisting() {
    return existing;
  }

  public void setExisting(boolean existing) {
    this.existing = existing;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("orderno", orderNo)
        .append("symbol", symbol)
        .append("qty", qty)
        .append("price", price)
        .append("time", time)
        .append("timestamp", timestamp)
        .append("side", side)
        .append("oi", oi)
        .append("existing", existing)
        .toString();
  }
}
