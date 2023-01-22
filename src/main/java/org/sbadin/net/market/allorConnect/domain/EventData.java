package org.sbadin.net.market.allorConnect.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventData {

  @JsonProperty("message")
  private String message;

  @JsonProperty("httpCode")
  private Integer httpCode;

  @JsonProperty("requestGuid")
  private String requestGuid;

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("message", message)
        .append("httpCode", httpCode)
        .append("requstGuid", requestGuid)
        .toString();
  }
}
