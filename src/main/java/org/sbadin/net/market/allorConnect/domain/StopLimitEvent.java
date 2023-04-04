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

}
