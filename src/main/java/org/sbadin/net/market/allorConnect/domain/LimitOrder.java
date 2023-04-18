package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitOrder {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("brokerSymbol")
  private String brokerSymbol;

  @JsonProperty("exchange")
  private Exchange exchange;

  @JsonProperty("type")
  private String type;

  @JsonProperty("side")
  private Side side;


  @JsonProperty("status")
  private StatusRequest status;

  @JsonProperty("transTime")
  private String transTime;

  @JsonProperty("endTime")
  private String endTime;

  @JsonProperty("qtyUnits")
  private Integer qtyUnits;

  @JsonProperty("qtyBatch")
  private Integer qtyBatch;

  @JsonProperty("qty")
  private Integer qty;

  @JsonProperty("filledQtyUnits")
  private Integer filledQtyUnits;

  @JsonProperty("filledQtyBatch")
  private Integer filledQtyBatch;

  @JsonProperty("filled")
  private Integer filled;

  @JsonProperty("price")
  private String price;

  @JsonProperty("existing")
  private Boolean existing;

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("symbol", symbol)
        .append("brokerSymbol", brokerSymbol)
        .append("exchange", exchange)
        .append("type", type)
        .append("side", side)
        .append("status", status)
        .append("transTime", transTime)
        .append("endTime", endTime)
        .append("qtyUnits", qtyUnits)
        .append("qtyBatch", qtyBatch)
        .append("qty", qty)
        .append("filledQtyUnits", filledQtyUnits)
        .append("filled", filledQtyBatch)
        .append("price", price)
        .append("existing", existing)
        .toString();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getBrokerSymbol() {
    return brokerSymbol;
  }

  public void setBrokerSymbol(String brokerSymbol) {
    this.brokerSymbol = brokerSymbol;
  }

  public Exchange getExchange() {
    return exchange;
  }

  public void setExchange(Exchange exchange) {
    this.exchange = exchange;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Side getSide() {
    return side;
  }

  public void setSide(Side side) {
    this.side = side;
  }

  public StatusRequest getStatus() {
    return status;
  }

  public void setStatus(StatusRequest status) {
    this.status = status;
  }

  public String getTransTime() {
    return transTime;
  }

  public void setTransTime(String transTime) {
    this.transTime = transTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Integer getQtyUnits() {
    return qtyUnits;
  }

  public void setQtyUnits(Integer qtyUnits) {
    this.qtyUnits = qtyUnits;
  }

  public Integer getQtyBatch() {
    return qtyBatch;
  }

  public void setQtyBatch(Integer qtyBatch) {
    this.qtyBatch = qtyBatch;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public Integer getFilledQtyUnits() {
    return filledQtyUnits;
  }

  public void setFilledQtyUnits(Integer filledQtyUnits) {
    this.filledQtyUnits = filledQtyUnits;
  }

  public Integer getFilledQtyBatch() {
    return filledQtyBatch;
  }

  public void setFilledQtyBatch(Integer filledQtyBatch) {
    this.filledQtyBatch = filledQtyBatch;
  }

  public Integer getFilled() {
    return filled;
  }

  public void setFilled(Integer filled) {
    this.filled = filled;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public Boolean getExisting() {
    return existing;
  }

  public void setExisting(Boolean existing) {
    this.existing = existing;
  }
}
