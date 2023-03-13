package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeEventData {

  @JsonProperty("data")
  private TradeEvent data;

  @JsonProperty("guid")
  private String guid;

  public TradeEvent getData() {
    return data;
  }

  public void setData(TradeEvent data) {
    this.data = data;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("data", data)
        .append("guid", guid)
        .toString();
  }
}
