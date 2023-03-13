package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * My trade.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeEvent {

  @JsonProperty("id")
  private String id;

  @JsonProperty("orderno")
  private String orderNo;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("brokerSymbol")
  private String brokerSymbol;

  @JsonProperty("exchange")
  private Exchange exchange;

  @JsonProperty("date")
  private String date;

  @JsonProperty("board")
  private String board;

  @JsonProperty("qtyUnits")
  private Integer qtyUnits;

  @JsonProperty("qtyBatch")
  private Integer qtyBatch;

  @JsonProperty("qty")
  private Integer qty;

  @JsonProperty("price")
  private String price;

  @JsonProperty("accruedInt")
  private Integer accruedInt;

  @JsonProperty("side")
  private Side side;

  @JsonProperty("existing")
  private Boolean existing;

  @JsonProperty("commission")
  private String commission;

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("orderno", orderNo)
        .append("symbol", symbol)
        .append("brokerSymbol", brokerSymbol)
        .append("exchange", exchange)
        .append("date", date)
        .append("board", board)
        .append("qtyUnits", qtyUnits)
        .append("qtyBatch", qtyBatch)
        .append("qty", qty)
        .append("price", price)
        .append("accruedInt", accruedInt)
        .append("side", side)
        .append("existing", existing)
        .append("commission", commission)
        .toString();
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
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

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getBoard() {
    return board;
  }

  public void setBoard(String board) {
    this.board = board;
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

  public Integer getAccruedInt() {
    return accruedInt;
  }

  public void setAccruedInt(Integer accruedInt) {
    this.accruedInt = accruedInt;
  }

  public Side getSide() {
    return side;
  }

  public void setSide(Side side) {
    this.side = side;
  }

  public Boolean getExisting() {
    return existing;
  }

  public void setExisting(Boolean existing) {
    this.existing = existing;
  }

  public String getCommission() {
    return commission;
  }

  public void setCommission(String commission) {
    this.commission = commission;
  }
}
