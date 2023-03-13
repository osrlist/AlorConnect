package org.sbadin.net.market.allorConnect;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Alor API error object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlorApiError {

  /**
   * Error code.
   */
  @JsonProperty("code")
  private int code;

  /**
   * Error message.
   */
  @JsonProperty("message")
  private String message;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("code", code)
        .append("message", message)
        .toString();
  }
}
