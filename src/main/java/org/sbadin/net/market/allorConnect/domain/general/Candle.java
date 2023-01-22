package org.sbadin.net.market.allorConnect.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
 public class Candle {

   @JsonProperty("time")
   private Long time;

   @JsonProperty("close")
   private String close;

   @JsonProperty("open")
   private String open;

   @JsonProperty("high")
   private String high;

   @JsonProperty("low")
   private String low;

   @JsonProperty("volume")
   private Long volume;


   public Long getTime() {
     return time;
   }

   public void setTime(Long time) {
     this.time = time;
   }

   public String getClose() {
     return close;
   }

   public void setClose(String close) {
     this.close = close;
   }

   public String getOpen() {
     return open;
   }

   public void setOpen(String open) {
     this.open = open;
   }

   public String getHigh() {
     return high;
   }

   public void setHigh(String high) {
     this.high = high;
   }

   public String getLow() {
     return low;
   }

   public void setLow(String low) {
     this.low = low;
   }

   public Long getVolume() {
     return volume;
   }

   public void setVolume(Long value) {
     this.volume = value;
   }

   @Override
   public String toString() {
     return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
         .append("time", time)
         .append("close", close)
         .append("open", open)
         .append("high", high)
         .append("low", low)
         .append("volume", volume)
         .toString();
   }
 }
