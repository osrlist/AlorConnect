package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionEvent {

  @JsonProperty("symbol")
  private String symbol;
  @JsonProperty("brokerSymbol")
  private String brokerSymbol;
  @JsonProperty("exchange")
  private Exchange exchange;
  @JsonProperty("avgPrice")
  private BigDecimal avgPrice;

  @JsonProperty("qtyUnits")
  private Integer qtyUnits;

  @JsonProperty("openUnits")
  private Integer openUnits;


  @JsonProperty("lotSize")
  private Integer lotSize;

  @JsonProperty("shortName")
  private String shortName;

  @JsonProperty("condition")
  private Condition condition;

  @JsonProperty("qtyT0")
  private Integer qtyT0;

  @JsonProperty("qtyT1")
  private Integer qtyT1;

  @JsonProperty("qtyT2")
  private Integer qtyT2;

  @JsonProperty("qtyTFuture")
  private Integer qtyTFuture;

  @JsonProperty("qtyT0Batch")
  private Integer qtyT0Batch;

  @JsonProperty("qtyT1Batch")
  private Integer qtyT1Batch;

  @JsonProperty("qtyT2Batch")
  private Integer qtyT2Batch;

  @JsonProperty("qtyTFutureBatch")
  private Integer qtyTFutureBatch;

  @JsonProperty("qtyBatch")
  private Integer qtyBatch;

  @JsonProperty("openQtyBatch")
  private Integer openQtyBatch;

  @JsonProperty("qty")
  private Integer qty;

  @JsonProperty("open")
  private Integer open;

  @JsonProperty("dailyUnrealisedPl")
  private BigDecimal dailyUnrealisedPl;

  @JsonProperty("unrealisedPl")
  private BigDecimal unrealisedPl;

  @JsonProperty("isCurrency")
  private Boolean isCurrency;


  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("symbol", symbol)
        .append("brokerSymbol", brokerSymbol)
        .append("exchange", exchange)
            .append("avgPrice", avgPrice)
        .append("qtyUnits", qtyUnits)
        .append("openUnits", openUnits)
        .append("lotSize", lotSize)
        .append("shortName", shortName)
        .append("qtyT0", qtyT0)
        .append("qtyT1", qtyT1)
        .append("qtyT2", qtyT2)
        .append("qtyTFuture", qtyTFuture)
        .append("qtyT0Batch", qtyT0Batch)
        .append("qtyT1Batch", qtyT1Batch)
        .append("qtyT2Batch", qtyT2Batch)
        .append("qtyTFutureBatch", qtyTFutureBatch)
        .append("qtyBatch", qtyBatch)
        .append("openQtyBatch", openQtyBatch)
        .append("qty", qty)
        .append("open", open)
        .append("dailyUnrealisedPl", dailyUnrealisedPl)
        .append("unrealisedPl", unrealisedPl)
        .append("isCurrency", isCurrency)
        .toString();
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

  public BigDecimal getAvgPrice() {
    return avgPrice;
  }

  public void setAvgPrice(BigDecimal avgPrice) {
    this.avgPrice = avgPrice;
  }

  public Integer getQtyUnits() {
    return qtyUnits;
  }

  public void setQtyUnits(Integer qtyUnits) {
    this.qtyUnits = qtyUnits;
  }

  public Integer getOpenUnits() {
    return openUnits;
  }

  public void setOpenUnits(Integer openUnits) {
    this.openUnits = openUnits;
  }

  public Integer getLotSize() {
    return lotSize;
  }

  public void setLotSize(Integer lotSize) {
    this.lotSize = lotSize;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public Integer getQtyT0() {
    return qtyT0;
  }

  public void setQtyT0(Integer qtyT0) {
    this.qtyT0 = qtyT0;
  }

  public Integer getQtyT1() {
    return qtyT1;
  }

  public void setQtyT1(Integer qtyT1) {
    this.qtyT1 = qtyT1;
  }

  public Integer getQtyT2() {
    return qtyT2;
  }

  public void setQtyT2(Integer qtyT2) {
    this.qtyT2 = qtyT2;
  }

  public Integer getQtyTFuture() {
    return qtyTFuture;
  }

  public void setQtyTFuture(Integer qtyTFuture) {
    this.qtyTFuture = qtyTFuture;
  }

  public Integer getQtyT0Batch() {
    return qtyT0Batch;
  }

  public void setQtyT0Batch(Integer qtyT0Batch) {
    this.qtyT0Batch = qtyT0Batch;
  }

  public Integer getQtyT1Batch() {
    return qtyT1Batch;
  }

  public void setQtyT1Batch(Integer qtyT1Batch) {
    this.qtyT1Batch = qtyT1Batch;
  }

  public Integer getQtyT2Batch() {
    return qtyT2Batch;
  }

  public void setQtyT2Batch(Integer qtyT2Batch) {
    this.qtyT2Batch = qtyT2Batch;
  }

  public Integer getQtyTFutureBatch() {
    return qtyTFutureBatch;
  }

  public void setQtyTFutureBatch(Integer qtyTFutureBatch) {
    this.qtyTFutureBatch = qtyTFutureBatch;
  }

  public Integer getQtyBatch() {
    return qtyBatch;
  }

  public void setQtyBatch(Integer qtyBatch) {
    this.qtyBatch = qtyBatch;
  }

  public Integer getOpenQtyBatch() {
    return openQtyBatch;
  }

  public void setOpenQtyBatch(Integer openQtyBatch) {
    this.openQtyBatch = openQtyBatch;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public Integer getOpen() {
    return open;
  }

  public void setOpen(Integer open) {
    this.open = open;
  }

  public BigDecimal getDailyUnrealisedPl() {
    return dailyUnrealisedPl;
  }

  public void setDailyUnrealisedPl(BigDecimal dailyUnrealisedPl) {
    this.dailyUnrealisedPl = dailyUnrealisedPl;
  }

  public BigDecimal getUnrealisedPl() {
    return unrealisedPl;
  }

  public void setUnrealisedPl(BigDecimal unrealisedPl) {
    this.unrealisedPl = unrealisedPl;
  }

  public Boolean getCurrency() {
    return isCurrency;
  }

  public void setCurrency(Boolean currency) {
    isCurrency = currency;
  }
}
