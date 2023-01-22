package org.sbadin.net.market.allorConnect.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
 public class History {

   @JsonProperty("history")
   private List<Candle> histories;

   @JsonProperty("next")
   private Long next;

   @JsonProperty("prev")
   private Long prev;

  public List<Candle> getHistories() {
    return histories;
  }

  public void setHistories(List<Candle> histories) {
    this.histories = histories;
  }

  public Long getNext() {
    return next;
  }

  public void setNext(Long next) {
    this.next = next;
  }

  public Long getPrev() {
    return prev;
  }

  public void setPrev(Long prev) {
    this.prev = prev;
  }

  @Override
   public String toString() {
     return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
         .append("history", histories)
         .append("next", next)
         .append("prev", prev)
         .toString();
   }
 }
