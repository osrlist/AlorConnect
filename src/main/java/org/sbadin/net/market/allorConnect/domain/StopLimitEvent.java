package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * My trade.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StopLimitEvent {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("exchangeOrderId")
  private Long exchangeOrderId;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("brokerSymbol")
  private String brokerSymbol;

  @JsonProperty("portfolio")
  private String portfolio;

  @JsonProperty("exchange")
  private Exchange exchange;

  @JsonProperty("type")
  private TypeRequest type;

  @JsonProperty("side")
  private Side side;

  @JsonProperty("condition")
  private Condition condition;

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

  @JsonProperty("price")
  private String price;

  @JsonProperty("avg_price")
  private String avg_price;

  @JsonProperty("stopPrice")
  private String stopPrice;

  @JsonProperty("existing")
  private Boolean existing;

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("exchangeOrderId", exchangeOrderId)
        .append("symbol", symbol)
        .append("brokerSymbol", brokerSymbol)
        .append("portfolio", portfolio)
        .append("exchange", exchange)
        .append("type", type)
        .append("side", side)
        .append("condition", condition)
        .append("status", status)
        .append("transTime", transTime)
        .append("endTime", endTime)
        .append("qtyUnits", qtyUnits)
        .append("qtyBatch", qtyBatch)
        .append("qty", qty)
        .append("price", price)
        .append("avg_price", avg_price)
        .append("stopPrice", stopPrice)
        .append("existing", existing)
        .toString();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getExchangeOrderId() {
    return exchangeOrderId;
  }

  public void setExchangeOrderId(Long exchangeOrderId) {
    this.exchangeOrderId = exchangeOrderId;
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

  public String getPortfolio() {
    return portfolio;
  }

  public void setPortfolio(String portfolio) {
    this.portfolio = portfolio;
  }

  public Exchange getExchange() {
    return exchange;
  }

  public void setExchange(Exchange exchange) {
    this.exchange = exchange;
  }

  public TypeRequest getType() {
    return type;
  }

  public void setType(TypeRequest type) {
    this.type = type;
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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getAvg_price() {
    return avg_price;
  }

  public void setAvg_price(String avg_price) {
    this.avg_price = avg_price;
  }

  public String getStopPrice() {
    return stopPrice;
  }

  public void setStopPrice(String stopPrice) {
    this.stopPrice = stopPrice;
  }

  public Boolean getExisting() {
    return existing;
  }

  public void setExisting(Boolean existing) {
    this.existing = existing;
  }
}
